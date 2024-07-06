package its.esame.esame.dto.loginDto;

import its.esame.esame.entity.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private String token;
    private UserRole role;
    private String username;
}
