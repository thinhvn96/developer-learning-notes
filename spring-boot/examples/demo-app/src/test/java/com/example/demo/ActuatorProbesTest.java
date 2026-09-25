package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ActuatorProbesTest {
    @Autowired MockMvc mvc;

    @Test void probesAndExposure() throws Exception {
        for (String p : new String[]{"/actuator/health", "/actuator/health/liveness", "/actuator/health/readiness", "/actuator/env", "/actuator/beans"}) {
            var r = mvc.perform(get(p)).andReturn().getResponse();
            System.out.println("RESULT GET " + p + " -> " + r.getStatus() + " " + r.getContentAsString().replaceAll("\\s+", " ").substring(0, Math.min(70, r.getContentAsString().length())));
        }
        mvc.perform(get("/actuator/health/liveness")).andExpect(status().isOk());
    }
}
