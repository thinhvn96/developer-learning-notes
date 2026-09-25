package com.example.demo.config;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("app")
@Validated
public record AppProperties(@NotBlank String name, @DefaultValue("hello") String greeting) { }
