package com.freemiumwear.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class DotenvEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        String profile = environment.getProperty("spring.profiles.active", "local");
        System.out.println("Active profile from DotenvEnvironmentPostProcessor: " + profile);
        String envFile = ".env." + profile;

        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(
                Paths.get(System.getProperty("user.dir"), envFile).toFile())) {

            props.load(fis);

            props.forEach((key, value) -> {
                String k = key.toString();
                String v = value.toString();

                environment.getSystemProperties().put(k, v);
                System.setProperty(k, v);
            });

            System.out.println("Loaded env file before Spring Boot: " + envFile);

        } catch (IOException e) {
            System.err.println("⚠ Could not load env file: " + envFile + " (" + e.getMessage() + ")");
        }
    }
}