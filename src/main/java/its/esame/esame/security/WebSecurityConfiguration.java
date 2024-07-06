package its.esame.esame.security;

import its.esame.esame.constants.AdminConstants;
import its.esame.esame.constants.UserConstants;
import its.esame.esame.entity.UserRole;
import its.esame.esame.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static org.springframework.http.HttpMethod.POST;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class WebSecurityConfiguration {

        private final AuthService authService;
        private final String[] AUTH_WHITE_LIST = {
                UserConstants.BASE_PATH + "/**"
        };

    @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(AbstractHttpConfigurer::disable)
                    .authorizeHttpRequests (authorizeRequests ->
                            authorizeRequests
                                    .requestMatchers(POST, AUTH_WHITE_LIST).permitAll()

                                    .requestMatchers(AdminConstants.BASE_PATH + "/**").hasAuthority(UserRole.ADMIN.name())
                                    .anyRequest().authenticated()
                    )
                                    .addFilterBefore(new JwtTokenAuthenticationFilter(authService), UsernamePasswordAuthenticationFilter.class);

            return http.build();
        }

}
