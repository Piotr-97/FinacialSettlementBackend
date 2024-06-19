package s18746.financialsettlementbackend.autht;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    private  String message;
    private  Code code;

    public AuthResponse(Code code) {
        this.message = code.label;
        this.code = code;
    }
}