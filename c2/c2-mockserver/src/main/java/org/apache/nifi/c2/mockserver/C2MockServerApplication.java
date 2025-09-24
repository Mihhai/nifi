package org.apache.nifi.c2.mockserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class C2MockServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(C2MockServerApplication.class, args);
    }
}
