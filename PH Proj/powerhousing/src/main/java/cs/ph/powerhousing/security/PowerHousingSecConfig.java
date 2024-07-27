package cs.ph.powerhousing.security;


import cs.ph.powerhousing.controllers.PHAuthSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class PowerHousingSecConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, PHAuthSuccessHandler phAuthSuccessHandler) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/home")
                                .loginProcessingUrl("/loginConfirmation")
                                .successHandler(phAuthSuccessHandler)
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .permitAll()
                                .logoutSuccessUrl("/")
                );

        return http.build();
    }

}
