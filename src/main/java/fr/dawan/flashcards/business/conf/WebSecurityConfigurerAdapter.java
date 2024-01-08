package fr.dawan.flashcards.business.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
@Configuration
public abstract class WebSecurityConfigurerAdapter implements
        WebSecurityConfigurer<WebSecurity> {

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated();
    }
}