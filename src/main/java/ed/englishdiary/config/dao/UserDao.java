package ed.englishdiary.config.dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDao {

    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User(
                    "choisang08@naver.com",
                    "$2a$10$Nwt5d4r8VowBBQcAdSutduSyQvSg3gt6w3iELhVwi9AoBSA7Gn0De",   // sksnzm62
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
            ),
            new User(
                    "gddb@naver.com",
                    "$2a$10$5vqJLrvG/ozIVoxSJa0oR.6niF/.ahXmCfutdOblz154euuQ1IX2q",   // dabi12@
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            )
    );

    public UserDetails findUserByEmail(String email) {
        return APPLICATION_USERS
                .stream()
                .filter(u -> u.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No user was found"));
    }

}
