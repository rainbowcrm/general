package com.primus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@ServletComponentScan
@SpringBootApplication
public class StartApplication extends SpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class,args);
    }

    /*@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
           *//* Thread subscriber = new Thread(ctx.getBean(SchedulerThread.class));
            subscriber.start();*//*

        };
    }*/
}