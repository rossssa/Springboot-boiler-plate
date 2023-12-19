package com.example.aboutbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 시간관련 annotaion
@SpringBootApplication
public class AboutbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(AboutbookApplication.class, args);
    }

}
