package com.stark.springbootpoststartupoptions.postconstruct;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PostConstructDemo {
    public PostConstructDemo() {
        System.out.println("\033[1;33m"+"\t\t\t\t PostConstructDemo Constructor called"+"\u001B[0m");
    }

    @PostConstruct
    public void runAfterObjectCreated() {
        System.out.println("\033[1;33m"+"\t\t\t\t In PostConstructDemo PostContruct method called"+"\u001B[0m");
    }
}
