package com.example.demo;

import com.example.demo.web.PersonController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/** A test SLICE: only the web layer is loaded (no JPA, no services). */
@WebMvcTest(PersonController.class)
class PersonControllerTest {
    @Autowired MockMvc mvc;

    @Test void getReturnsJson() throws Exception {
        mvc.perform(get("/persons/7")).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("person-7"));
        System.out.println("RESULT GET /persons/7 -> 200 OK");
    }

    @Test void validPostReturns201() throws Exception {
        mvc.perform(post("/persons").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"Ann\",\"age\":30}"))
           .andExpect(status().isCreated());
        System.out.println("RESULT POST valid body -> 201 Created");
    }

    @Test void invalidPostReturns400() throws Exception {
        var r = mvc.perform(post("/persons").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"\",\"age\":-1}"))
           .andExpect(status().isBadRequest()).andReturn();
        System.out.println("RESULT POST invalid body (blank name, age -1) -> " + r.getResponse().getStatus() + " Bad Request");
    }
}
