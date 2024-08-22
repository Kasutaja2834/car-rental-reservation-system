package org.sta.crrs.car_rental_reservation_system.services.WebSecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration(proxyBeanMethods = false)
@EnableMethodSecurity
public class WebSecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new MySQLUserDetailsService();
    }

    static class MySQLUserDetailsService implements UserDetailsService {
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return User.builder().username("admin").password("123456").authorities("admin").build();
        }
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
//                .authorizeHttpRequests(c -> c.requestMatchers("/", "/home", "/register", "/css/**.css", "/js/**").permitAll().anyRequest().authenticated())//
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(c -> c.anyRequest().permitAll())
                .formLogin(c -> c.loginPage("/login").permitAll())
                .logout(c -> c
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                )
                .build();
    }
}

//antMatchers" means an implementation of Apache Ant Project Ant-style path patterns in mappings.

//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    return http.authorizeHttpRequests(c -> c
//            .requestMatchers("/", "/home", "/register", "/css/**.css", "/js/**").permitAll()
//            .anyRequest().authenticated()
//        )
//        .formLogin(c -> c
//            .loginPage("/login").permitAll()
//        )
//        .logout(c -> c
//            .logoutUrl("/logout")
//            .logoutSuccessUrl("/login?logout")
//            .invalidateHttpSession(true)
//            .deleteCookies("JSESSIONID")
//            .permitAll()
//        )
//        .build();
//}