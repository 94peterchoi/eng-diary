package ed.englishdiary.security;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class BcryptTest {

    @Test
    public void printEncodedPassword() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String plainPassword = "sksnzm62";
        String encryptedPassword = bCryptPasswordEncoder.encode(plainPassword);

        String plainPassword2 = "dabi12@";
        String encryptedPassword2 = bCryptPasswordEncoder.encode(plainPassword2);

        System.out.println(encryptedPassword);
        System.out.println(encryptedPassword2);
    }


}
