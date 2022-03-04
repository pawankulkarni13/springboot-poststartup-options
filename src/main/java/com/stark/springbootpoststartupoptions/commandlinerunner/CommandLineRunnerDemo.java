package com.stark.springbootpoststartupoptions.commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * We can create multiple CommandLineRunners in one application. Using the Ordered interface or @Order annotation
 * we can configure the order in which they should run. Lower value means higher the priority.
 * By default all the components are created with lowest priority. That is why components without order configuration will be called last.
 */

@Component
@Order(1)
public class CommandLineRunnerDemo implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("\u001B[35m"+"\t\t\t\t In CommandLineRunnerDemo run()"+"\u001B[0m");
    }
}