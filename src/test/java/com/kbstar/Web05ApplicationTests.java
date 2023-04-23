package com.kbstar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;

import java.util.Locale;

@SpringBootTest
class Web05ApplicationTests {
    @Autowired
    private MessageSource messageSource;


    @Test
    void contextLoads() {
        String text = messageSource.getMessage("site.title", null, Locale.KOREA);
        System.out.println("----------------------------------");

        System.out.println(text);
    }

}
