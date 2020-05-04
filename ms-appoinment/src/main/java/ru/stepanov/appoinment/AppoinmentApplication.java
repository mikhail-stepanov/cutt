package ru.stepanov.appoinment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.stepanov")
public class AppoinmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppoinmentApplication.class, args);
    }

}
