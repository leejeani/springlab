package com.kbstar.fcm;

import com.kbstar.util.PushNotificationUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

@Slf4j
@SpringBootTest
class FcmTests {

    @Autowired
    private PushNotificationUtil pushNotificationUtil;

    @Test
    void contextLoads() throws IOException {

        pushNotificationUtil.sendCommonMessage("SPRING", "SPRING", "/register");
    }

}
