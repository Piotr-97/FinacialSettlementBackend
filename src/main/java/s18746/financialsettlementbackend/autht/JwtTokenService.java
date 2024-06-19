package s18746.financialsettlementbackend.autht;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class JwtTokenService {

    public final String SECRET;

    public JwtTokenService(@Value("${jwt.secret}") String secret) {
        SECRET = secret;
    }

    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        String token = JWT.create()
                .withSubject(user.getUsername())
                .withClaim("roles" ,user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
        return token;
    }
}
