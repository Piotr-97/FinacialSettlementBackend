package s18746.financialsettlementbackend.security;


import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TokenControllerErrorHandler {
    private static  final String BAD_CREDENTIALS = "Bad credentials";

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public TokenErrorResponse handleBadCredentials(){
        return new TokenErrorResponse(BAD_CREDENTIALS,HttpStatus.UNAUTHORIZED);
    }
}
