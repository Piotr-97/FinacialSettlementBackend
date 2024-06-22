package s18746.financialsettlementbackend.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s18746.financialsettlementbackend.autht.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest authRequest) {

        return authService.logIn(authRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest registerRequest){
        try {
            authService.register(registerRequest);
            return ResponseEntity.ok( new AuthResponse(Code.SUCCESS));
        }catch (UserExistingWithNameException e){
            return ResponseEntity.status(400).body(new AuthResponse(Code.LOGIN_ALREADY_EXISTS));
        }


    }
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody RecoveryPasswordData email){
        try {
            authService.recoveryPassword(email);
            return ResponseEntity.ok(new AuthResponse(Code.SUCCESS));
        }catch (UserExistingWithNameException e){
            return ResponseEntity.status(400).body(new AuthResponse(Code.USERNAME_ERROR));
        }
    }

    @PatchMapping("/reset-password/{uuid}")
    public ResponseEntity<?> resetPassword(@RequestBody PasswordChangeData passwordChangeData,@PathVariable String uuid){
        try {
            authService.changePassword(passwordChangeData.password(),uuid);
            return ResponseEntity.ok(new AuthResponse(Code.SUCCESS));
        }catch (UserExistingWithNameException e){
            return ResponseEntity.status(400).body(new AuthResponse(Code.USERNAME_ERROR));
        }
    }

    @PostMapping()
    public ResponseEntity<?> changeRole(@RequestBody RoleChangeData roleChangeData){
        try {
            authService.changeRole(roleChangeData.uuid(),roleChangeData.role());
            return ResponseEntity.ok(new AuthResponse(Code.SUCCESS));
        }catch (UserExistingWithNameException e){
            return ResponseEntity.status(400).body(new AuthResponse(Code.USER_NOT_EXISTS));
        }
    }



}
