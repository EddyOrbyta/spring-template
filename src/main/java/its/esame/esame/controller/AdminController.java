package its.esame.esame.controller;

import its.esame.esame.constants.AdminConstants;
import its.esame.esame.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(AdminConstants.BASE_PATH)
@Slf4j
public class AdminController {
    private final AuthService authService;
    @GetMapping(AdminConstants.PROVA)
    public ResponseEntity<String> prova(@RequestHeader(value = "Authorization") String jwt) {

        String token = authService.getToken(jwt);

        log.info("Start method prova for token {} with role admin , jwt role {}", jwt , authService.getRole(token));

        return ResponseEntity.ok("Funziona");
    }
}
