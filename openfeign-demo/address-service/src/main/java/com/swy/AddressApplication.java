package com.swy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
public class AddressApplication {
    public static void main( String[] args )
    {
        try {
            SpringApplication.run(AddressApplication.class, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
