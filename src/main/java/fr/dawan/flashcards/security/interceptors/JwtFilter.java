package fr.dawan.flashcards.security.interceptors;

import fr.dawan.flashcards.security.conf.SecurityConfig;
import fr.dawan.flashcards.security.tools.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {
    private final UserDetailsService service;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("request.getRequestURI() = " + request.getRequestURI());
        if (!request.getMethod().equals("OPTIONS") && isInterceptedUri(request.getRequestURI())) {
            String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                throw new ServletException("Invalid Authorization");
            }
            String token = authHeader.substring(7);
            try {
                String username = JwtUtils.extractUsername(token);

                if (username!= null){
                    UserDetails userDetails = service.loadUserByUsername(username);
                    log.info("userDetails = " + userDetails);
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, token, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            } catch (Exception e) {
                throw new ServletException("Invalid token");
            }
        }
        filterChain.doFilter(request,response);
    }

    private boolean isInterceptedUri(String uri) {
        return Stream.concat(Arrays.stream(SecurityConfig.AUTHORIZED_GET), Arrays.stream(SecurityConfig.AUTHORIZED_URL))
                .map(url -> url.replace("**",".*"))
                .noneMatch(uri::matches);
    }
}
