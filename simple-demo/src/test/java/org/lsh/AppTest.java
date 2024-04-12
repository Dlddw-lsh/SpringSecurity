package org.lsh;


import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AppTest {
    @Test
    public void testApp() {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
