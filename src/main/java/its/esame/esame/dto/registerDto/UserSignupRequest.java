package its.esame.esame.dto.registerDto;

import lombok.Data;

@Data
public class UserSignupRequest {
    private String username;
    private String password;
}
