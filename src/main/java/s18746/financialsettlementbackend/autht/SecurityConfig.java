package s18746.financialsettlementbackend.autht;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserRepository userRepository;
    private final JwtTokenFilter jwtTokenFilter;
    private final CorsFilter corsFilter;

    @Bean
    public AuthenticationManager authorizationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        return username ->
            userRepository.findUserByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User with given login not found" + username) );

    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests((autorization)
                        -> autorization
                        .requestMatchers("/auth/register","/auth/change-role", "/auth/login", "/auth/reset-password", "/auth/reset-password/**","auth/test",
                                "/financialsettlement/**","/accountant/**", "/accountant/**","/projects/**").permitAll()
                        .requestMatchers("/auth/test2").hasRole("ADMIN")

                        .anyRequest().authenticated()
                )
                .build();
    }

//        @Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    SecurityFilterChain h2ConsoleSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.securityMatcher(PathRequest.toH2Console())
//                .authorizeHttpRequests((authorize) -> authorize.anyRequest().permitAll())
//                .csrf(AbstractHttpConfigurer::disable)
//                .headers((headers) -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
//        return http.build();
//    }
}
