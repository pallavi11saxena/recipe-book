package com.recipebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author pallavi
 * Main application call to run the app.
 */

@SpringBootApplication
public class RecipeBookApplication {

    /**
     * Main method to start the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(RecipeBookApplication.class, args);
    }
}
