package se.experis.HvZ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import se.experis.HvZ.service.GameUserDetailServiceImpl;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private GameUserDetailServiceImpl gameUserDetailService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(gameUserDetailService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    /*@Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/api/games");
    }*/



    // We stipulate that the POST method request to the /login endpoint is allowed without authentication
    // and that requests to all other endpoints require authentication.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Add this row to allow access to all endpoints
        http.csrf().disable().cors().and().authorizeRequests().anyRequest().permitAll();

       /* http.csrf().disable().cors().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/games").permitAll()
                .antMatchers(HttpMethod.GET, "/api/gameUsers").permitAll()
                .antMatchers(HttpMethod.POST, "/api/gameUsers").permitAll().anyRequest().authenticated()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                    .anyRequest().authenticated()
                    .and()
                // Filter for the api/login request
                    .addFilterBefore(new LoginFilter("/login",
                        authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                // Filter for other requests to check JWT in header
                    .addFilterBefore(new AuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
*/

    }


    //
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("*"));
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowCredentials(true);
        config.applyPermitDefaultValues();

        source.registerCorsConfiguration("/**", config);
        return source;
    }
}