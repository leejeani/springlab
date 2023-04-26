package com.kbstar;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //uploadPath프로퍼티값을 읽어온다
    //@Value("${uploadpath}")
    String uploadPath= "file:///C:/projectimg/img/";
    String logdir= "file:///C:/logs/";
    // c:/projectimg/img

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations(uploadPath);
        registry.addResourceHandler("/logs/**").addResourceLocations(logdir);
        //로컬컴퓨터에 저장된 파일을 읽어올 root경로
    }


}
