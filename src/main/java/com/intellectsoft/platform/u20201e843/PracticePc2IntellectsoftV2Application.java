package com.intellectsoft.platform.u20201e843;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PracticePc2IntellectsoftV2Application {

    public static void main(String[] args) {
        SpringApplication.run(PracticePc2IntellectsoftV2Application.class, args);
    }

}
