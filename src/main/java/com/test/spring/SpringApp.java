package com.test.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    public static void initSpring() {
        if (context.isActive()){
        } else {
            context.register(SpringConfig.class);
            context.refresh();
        }
    }

    public static void killSpring() {
        if (context.isActive()) {
            context = new AnnotationConfigApplicationContext();
            context.register(SpringConfig.class);
            context.refresh();
        }
    }

    public static AnnotationConfigApplicationContext getContext() {
        return context;
    }
}
