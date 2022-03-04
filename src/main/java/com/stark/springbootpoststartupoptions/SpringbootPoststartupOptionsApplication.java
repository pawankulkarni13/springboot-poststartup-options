package com.stark.springbootpoststartupoptions;

import com.stark.springbootpoststartupoptions.initmethod.BeanInitMethodDemo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class SpringbootPoststartupOptionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootPoststartupOptionsApplication.class, args);
    }

    @Bean
    public CommandLineRunner CommandLineRunnerBean() {
        return (args) -> {
            System.out.println("\033[1;34m"+"\t\t\t\tIn CommandLineRunner Bean creation "+"\u001B[0m");
        };
    }

    @Bean(initMethod="runAfterObjectCreated")
    public BeanInitMethodDemo beanInitMethodDemo() {
        return new BeanInitMethodDemo();
    }
}
