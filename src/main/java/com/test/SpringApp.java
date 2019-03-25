package com.test;

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

    public static AnnotationConfigApplicationContext getContext() {
        return context;
    }
}
