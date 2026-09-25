package com.example.demo.web;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record PersonRequest(@NotBlank String name, @Min(0) int age) { }
