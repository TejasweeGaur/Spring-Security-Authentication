package com.authentication.backend.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for setting up Spring Security in the authentication
 * backend.
 */
@Configuration
public class SpringSecurityConfiguration {

    /**
     * Bean definition for creating a BCryptPasswordEncoder, which is used for
     * password encoding.
     *
     * @return An instance of BCryptPasswordEncoder.
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Bean definition for creating an AuthenticationManager.
     *
     * @param userDetailsService The user details service used for authentication.
     * @return An instance of AuthenticationManager configured with a
     *         DaoAuthenticationProvider.
     */
    @Bean
    AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);

        return new ProviderManager(daoAuthenticationProvider);
    }

    /**
     * Bean definition for setting up Spring Security filters and configurations.
     *
     * @param httpSecurity The HttpSecurity object to configure security settings.
     * @return A SecurityFilterChain configured with disabled CSRF, requiring all
     *         requests to be authenticated,
     *         and using HTTP Basic authentication.
     * @throws Exception If an error occurs during the configuration.
     */
    @Bean
    SecurityFilterChain setSpringSecurity(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(crossOrigin -> crossOrigin.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }
}
