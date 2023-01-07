package ed.englishdiary.main;

import ed.englishdiary.config.JwtUtil;
import ed.englishdiary.config.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        final UserDetails user = userDao.findUserByEmail(request.getEmail());
        if (user != null) {
            return ResponseEntity.ok(jwtUtil.generateToken(user));
        }

        return ResponseEntity.status(400).body("Some error has occurred");
    }


    @PostMapping("/authenticate2")
    public ResponseEntity<String> authenticate(HttpServletRequest request, HttpServletResponse response) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getParameter("email"), request.getParameter("password"))
        );

        final UserDetails user = userDao.findUserByEmail(request.getParameter("email"));
        if (user != null) {
            String jwtToken = jwtUtil.generateToken(user);
//            response.addHeader("Authorization", "Bearer " + jwtToken);
            Cookie cookie = new Cookie("login_token", jwtToken);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 30);

            response.addCookie(cookie);
            return ResponseEntity.ok(jwtToken);
        }

        return ResponseEntity.status(400).body("Some error has occurred");
    }


}
