package com.example.demo.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

public class Scopes {
    /** Default scope: singleton, one shared instance per container. */
    @Component
    public static class SingletonThing { }

    /** Prototype: a new instance each time it is requested from the container. */
    @Component
    @Scope("prototype")
    public static class PrototypeThing {
        private static final AtomicInteger COUNTER = new AtomicInteger();
        public final int id = COUNTER.incrementAndGet();
    }

    /** A singleton that gets its prototype dependency injected ONCE, at construction. */
    @Component
    public static class Holder {
        public final PrototypeThing injectedOnce;
        private final ObjectProvider<PrototypeThing> provider;
        public Holder(PrototypeThing injectedOnce, ObjectProvider<PrototypeThing> provider) {
            this.injectedOnce = injectedOnce;
            this.provider = provider;
        }
        public PrototypeThing freshOne() { return provider.getObject(); }
    }
}
