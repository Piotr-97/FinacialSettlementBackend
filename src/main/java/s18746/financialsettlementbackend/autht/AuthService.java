package s18746.financialsettlementbackend.autht;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import s18746.financialsettlementbackend.employeemanager.EmployeeManagerFacade;
import s18746.financialsettlementbackend.employeemanager.RegisterEmployee;
import s18746.financialsettlementbackend.messagesender.MessageSenderFacade;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    private final EmployeeManagerFacade employeeManagerFacade;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final MessageSenderFacade messageSenderFacade;


    public ResponseEntity<?> logIn(AuthRequest authRequest) {
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.login(), authRequest.password()));
            User user = (User) authenticate.getPrincipal();
            String token = jwtTokenService.generateToken(user);
            return ResponseEntity.ok().body(new LoginResponse(authRequest.login(), token,user.getRole().toString(), user.getUuid()));
        } catch (UsernameNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(null,null,null, null));
        }
    }

      public void register(RegisterRequest registerRequest) throws UserExistingWithNameException{
        userRepository.findUserByEmail(registerRequest.email()).ifPresent(value ->{
                throw new UserExistingWithNameException("User with given login already exists");
        });

        User user = new User();
        user.setEmail(registerRequest.email());
        user.setPassword(passwordEncoder.encode(registerRequest.password()));
        if (registerRequest.role() != null) {
            user.setRole(Role.valueOf(registerRequest.role()));
        } else {
            user.setRole(Role.ROLE_USER);
        }
          RegisterEmployee registerEmployee = new RegisterEmployee( registerRequest.firstname(), registerRequest.lastname(), registerRequest.mobilePhone(),registerRequest.email());
        userRepository.save(user);
        employeeManagerFacade.addEmployee(registerEmployee,user);
    }

    public void recoveryPassword(RecoveryPasswordData recoveryPasswordData) throws UserExistingWithNameException{
        Optional<User> user = userRepository.findUserByEmail(recoveryPasswordData.email());
        if(user.isPresent()){
            User presentUser = user.get();
            messageSenderFacade.sendPasswordRecovery(presentUser.getEmail(),presentUser.getUuid());
            return;
        }
        throw  new UserExistingWithNameException("User Doesn't exist");
    }

    public void changePassword(String password, String uuid) {
        Optional<User> userByUuid = userRepository.findUserByUuid(uuid);
        if(userByUuid.isPresent()){
            User presentUser = userByUuid.get();
            presentUser.setPassword(passwordEncoder.encode(password));
            return;
        }
        throw  new UserExistingWithNameException("User Doesn't exist");
    }

    public void changeRole(String uuid, String role){
        Optional<User> userByUuid = userRepository.findUserByUuid(uuid);
        if(userByUuid.isPresent()){
            userByUuid.get().setRole(Role.valueOf(role));
            userRepository.save(userByUuid.get());
            return;
        }
        throw new UserWithUuidNotFoundException("User not found");
    }
}

