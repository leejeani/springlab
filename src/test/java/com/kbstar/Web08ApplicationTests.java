package com.kbstar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.util.Locale;

@SpringBootTest
class Web08ApplicationTests {
    @Autowired
    private MessageSource messageSource;


    @Test
    void contextLoads() {
        String text = messageSource.getMessage("site.title", null, Locale.KOREA);
        System.out.println("----------------------------------");

        System.out.println(text);
    }

}
