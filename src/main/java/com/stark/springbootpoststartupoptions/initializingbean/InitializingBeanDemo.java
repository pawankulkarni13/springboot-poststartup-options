package com.stark.springbootpoststartupoptions.initializingbean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class InitializingBeanDemo implements InitializingBean {
    public InitializingBeanDemo() {
        System.out.println("\u001B[31m"+"\t\t\t\t InitializingBeanDemo Constructor called"+"\u001B[0m");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("\u001B[31m"+"\t\t\t\t In InitializingBeanDemo afterPropertiesSet method called"+"\u001B[0m");
    }
}
