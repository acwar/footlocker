package org.aag.footlocker.ragbagspringresttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.aag.footlocker.ragbagspringresttest.controller")
public class RagbagSpringresttestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RagbagSpringresttestApplication.class, args);
    }

}
