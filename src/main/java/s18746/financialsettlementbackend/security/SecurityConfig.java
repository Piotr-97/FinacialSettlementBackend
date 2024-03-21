package s18746.financialsettlementbackend.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import s18746.financialsettlementbackend.login.LoginAndRegisterFacade;

@Configuration
@AllArgsConstructor
public class SecurityConfig{


    private final LoginAndRegisterFacade loginAndRegisterFacade;

   @Bean
   public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception {
       return authenticationConfiguration.getAuthenticationManager();
   }

   @Bean
    public UserDetailsService userDetailsService(LoginAndRegisterFacade loginAndRegisterFacade){
       return new LoginUserDetailService(loginAndRegisterFacade);
   }


}
