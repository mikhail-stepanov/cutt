package ru.stepanov.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.stepanov")
public class SmtpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmtpApplication.class, args);
    }

}
