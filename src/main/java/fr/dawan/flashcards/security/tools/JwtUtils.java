package fr.dawan.flashcards.security.tools;

import fr.dawan.flashcards.FlashCardsApplication;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtils {

    private JwtUtils() {
	}

    private static final String SECRET_KEY = FlashCardsApplication.getSecret();
    private static final long TOKEN_DURATION = Duration.ofHours(2).toMillis();
    private static final long REFRESH_TOKEN_DURATION = Duration.ofDays(7).toMillis();

    public static String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public static Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public static <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private static Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public static Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public static String generateToken(UserDetails userDetails) {
        return createToken(userDetails, new Date(System.currentTimeMillis() + TOKEN_DURATION));
    }

    public static String generateRefreshToken(UserDetails userDetails) {
        return createToken(userDetails, new Date(System.currentTimeMillis() + REFRESH_TOKEN_DURATION));
    }

    private static Map<String, Object> getClaims(UserDetails userDetails) {
        if (userDetails == null)
            throw new UsernameNotFoundException("User not found");
        Map<String, Object> claims = new HashMap<>();
        claims.put("authorities", userDetails.getAuthorities());
        //Add other claim if needed
        return claims;
    }

    private static String createToken(UserDetails userDetails, Date expiration) {

        return Jwts.builder().setClaims(getClaims(userDetails)).setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
