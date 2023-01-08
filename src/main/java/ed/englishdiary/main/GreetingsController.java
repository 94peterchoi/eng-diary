package ed.englishdiary.main;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greetings")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class GreetingsController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello API");
    }

    @GetMapping("/say-good-bye")
    public ResponseEntity<String> sayGoodBye() {
        return ResponseEntity.ok("Good bye and see you again");
    }

}
