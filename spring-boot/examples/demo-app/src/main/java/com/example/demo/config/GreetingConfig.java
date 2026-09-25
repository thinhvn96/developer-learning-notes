package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingConfig {
    public interface Source { String name(); }

    @Bean @Profile("!dev")
    Source defaultSource() { return () -> "default-profile bean"; }

    @Bean @Profile("dev")
    Source devSource() { return () -> "dev-profile bean"; }
}
