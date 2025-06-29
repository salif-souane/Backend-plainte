/* 
package Salif.s.sa.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity  
public class ConfigurationSecurityApplication {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return
                httpSecurity
                        .csrf(AbstractHttpConfigurer::disable)
                        .authorizeHttpRequests(
                                 authorise ->
                                        authorise.requestMatchers(POST, "/api/client/inscription").permitAll()
                                            .anyRequest().authenticated()
                        ).build();
    }
}
    */