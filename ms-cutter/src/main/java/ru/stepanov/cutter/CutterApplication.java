package ru.stepanov.cutter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.stepanov")
public class CutterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CutterApplication.class, args);
    }

}
