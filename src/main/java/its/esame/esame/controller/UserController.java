package its.esame.esame.controller;

import its.esame.esame.constants.UserConstants;
import its.esame.esame.dto.loginDto.UserLoginRequest;
import its.esame.esame.dto.loginDto.AuthenticationResponse;
import its.esame.esame.dto.registerDto.UserSignupRequest;
import its.esame.esame.exception.PasswordDoesntMatchException;
import its.esame.esame.exception.UserAlreadyExistException;
import its.esame.esame.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(UserConstants.BASE_PATH)
public class UserController {

    private final UserService userService;

    @PostMapping(UserConstants.SIGNUP)
    public ResponseEntity<AuthenticationResponse> signup(@RequestBody UserSignupRequest userSignupRequest) throws UserAlreadyExistException {

        AuthenticationResponse authenticationResponse = userService.signUp(userSignupRequest);

        return ResponseEntity.ok(authenticationResponse);
    }
    @PostMapping(UserConstants.LOGIN)
    public ResponseEntity<AuthenticationResponse> login(@RequestBody UserLoginRequest userLogin) throws UserAlreadyExistException, PasswordDoesntMatchException {

        AuthenticationResponse authenticationResponse = userService.logIn(userLogin);

        return ResponseEntity.ok(authenticationResponse);
    }
}
