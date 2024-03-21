package s18746.financialsettlementbackend.security;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import s18746.financialsettlementbackend.login.LoginAndRegisterFacade;
import s18746.financialsettlementbackend.login.UserDto;

import java.util.Collections;


@AllArgsConstructor
public class LoginUserDetailService implements UserDetailsService {


   private final LoginAndRegisterFacade loginAndRegisterFacade;
    @Override
    // 14 36
    public UserDetails loadUserByUsername(String username) throws BadCredentialsException {
      UserDto userDto =  loginAndRegisterFacade.findByUsername(username);
       return getUser(userDto);
    }

    private org.springframework.security.core.userdetails.User getUser(UserDto user){
        return new org.springframework.security.core.userdetails.User(
                user.username(),
                user.password(),
                Collections.emptyList()
        );
    }
}
