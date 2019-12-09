package org.aag.footlocker.ragbagsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.aag.footlocker.ragbagsecurity.controllers", "org.aag.footlocker.ragbagsecurity.config"})
public class RagbagSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(RagbagSecurityApplication.class, args);
    }

}
