package com.example.demo;

import com.example.demo.config.Scopes.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ScopeTest {
    @Autowired ApplicationContext ctx;
    @Autowired Holder holder;

    @Test void singletonIsShared() {
        boolean same = ctx.getBean(SingletonThing.class) == ctx.getBean(SingletonThing.class);
        System.out.println("RESULT singleton getBean twice, same instance: " + same);
        assertThat(same).isTrue();
    }

    @Test void prototypeIsNewEachTime() {
        int a = ctx.getBean(PrototypeThing.class).id, b = ctx.getBean(PrototypeThing.class).id;
        System.out.println("RESULT prototype getBean twice, ids: " + a + " and " + b);
        assertThat(a).isNotEqualTo(b);
    }

    @Test void prototypeInsideSingletonIsInjectedOnce() {
        int once1 = holder.injectedOnce.id, once2 = holder.injectedOnce.id;
        int fresh1 = holder.freshOne().id, fresh2 = holder.freshOne().id;
        System.out.println("RESULT injected prototype ids: " + once1 + ", " + once2 + "   ObjectProvider ids: " + fresh1 + ", " + fresh2);
        assertThat(once1).isEqualTo(once2);
        assertThat(fresh1).isNotEqualTo(fresh2);
    }
}
