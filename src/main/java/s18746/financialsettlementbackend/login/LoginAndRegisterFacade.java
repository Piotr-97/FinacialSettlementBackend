package s18746.financialsettlementbackend.login;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class LoginAndRegisterFacade {

    private static final String USER_NOT_FOUND = "User not found";

    private final LoginRepository loginRepository;

    public UserDto findByUsername(String username){
        return loginRepository.findByUsername(username).map(applicationUser ->
                        new UserDto(applicationUser.getId(), applicationUser.getUsername(), applicationUser.getPassword()))
                .orElseThrow(()-> new BadCredentialsException(USER_NOT_FOUND));
    }

    public RegistrationResultDto register(RegisterUserDto registerUserDto){
        final ApplicationUser applicationUser = ApplicationUser.builder()
                .username(registerUserDto.username())
                .password(registerUserDto.password())
                .build();
        ApplicationUser savedApplicationUser = loginRepository.save(applicationUser);
        return new RegistrationResultDto(savedApplicationUser.id,true, savedApplicationUser.username);
    }

}
