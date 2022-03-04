package com.stark.springbootpoststartupoptions.event;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RunAfterStartup {

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        System.out.println("\u001B[37m"+"\t\t\t\t In RunAfterStartup ApplicationReadyEvent event"+"\u001B[0m");
    }
}
