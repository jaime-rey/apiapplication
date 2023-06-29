package io.getarrays.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

import static org.springframework.http.HttpMethod.POST;

@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalAuthentication
public class WebSecurityConfiguration {
    private final AccountAuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authenticationProvider);
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.authorizeHttpRequests(auth -> auth
                .requestMatchers(POST, "/api/accounts/**").permitAll()
                .anyRequest().hasAnyRole("USER","ADMIN")).sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

  /*  @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authenticationProvider);
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeRequests().requestMatchers(POST, "/api/accounts/**").permitAll();
        http.authorizeRequests()
                .anyRequest()
                .hasAnyRole("USER", "ADMIN")
                .and()
                .httpBasic(Customizer.withDefaults())
                .sessionManagement()
                .sessionCreationPolicy(STATELESS);
        return http.build();
    }*/

    /*
     * @Bean
     * public UserDetailsService userDetailsService() {
     * UserDetails user = User.withUsername("user")
     * .password("password")
     * .roles("USER")
     * .build();
     * UserDetails admin = User.withUsername("admin")
     * .password("password")
     * .roles("ADMIN", "USER")
     * .build();
     * return new InMemoryUserDetailsManager(user, admin);
     * }
     */
}
