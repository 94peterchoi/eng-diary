package ed.englishdiary.security;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class BcryptTest {

    @Test
    public void verifyEncodedPassword() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String plainPassword = "sksnzm62";
        String encryptedPassword = bCryptPasswordEncoder.encode(plainPassword);

        System.out.println(encryptedPassword);

    }


}
