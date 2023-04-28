package com.kbstar;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Slf4j
@SpringBootTest
class Web10ApplicationTests {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Test
    void contextLoads() {
        String rawPassword = "333333333333333333";
        String encPassword = encoder.encode(rawPassword);
        log.info("암호화 된 비번" + encPassword);
        boolean result = encoder.matches("111",encPassword);
        log.info(result+"");
    }

}
