package com.example.demo;

import com.example.demo.config.AppProperties;
import com.example.demo.config.GreetingConfig;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

class ConfigAndProfileTest {

    @Nested @SpringBootTest
    class DefaultProfile {
        @Autowired AppProperties props;
        @Autowired GreetingConfig.Source source;
        @Test void bindsProperties() {
            System.out.println("RESULT default profile: name=" + props.name() + " greeting=" + props.greeting() + " bean=" + source.name());
            assertThat(props.greeting()).isEqualTo("hello");
            assertThat(source.name()).isEqualTo("default-profile bean");
        }
    }

    @Nested @SpringBootTest @ActiveProfiles("dev")
    class DevProfile {
        @Autowired AppProperties props;
        @Autowired GreetingConfig.Source source;
        @Test void devOverrides() {
            System.out.println("RESULT dev profile:     name=" + props.name() + " greeting=" + props.greeting() + " bean=" + source.name());
            assertThat(props.greeting()).isEqualTo("hello from the dev profile");
            assertThat(source.name()).isEqualTo("dev-profile bean");
        }
    }

    /** Command-line style properties (same mechanism as --app.greeting=... or APP_GREETING) win over files. */
    @Nested @SpringBootTest(properties = "app.greeting=from a higher-precedence source") @ActiveProfiles("dev")
    class PrecedenceOverProfileFile {
        @Autowired AppProperties props;
        @Test void higherPrecedenceWins() {
            System.out.println("RESULT dev profile + test property: greeting=" + props.greeting());
            assertThat(props.greeting()).isEqualTo("from a higher-precedence source");
        }
    }
}
