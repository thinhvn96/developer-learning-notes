package com.example.demo.web;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @GetMapping("/{id}")
    public PersonRequest get(@PathVariable Long id) { return new PersonRequest("person-" + id, 30); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonRequest add(@Valid @RequestBody PersonRequest person) { return person; }
}
