package its.esame.esame.dto.loginDto;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String username;
    private String password;
}
