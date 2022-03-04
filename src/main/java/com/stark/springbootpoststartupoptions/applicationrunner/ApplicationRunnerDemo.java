package com.stark.springbootpoststartupoptions.applicationrunner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnerDemo implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args)  {

        System.out.println("\u001B[33m"+"\t\t\t\t In ApplicationRunnerDemo run()"+"\u001B[0m");

        //Can print additional info based on arguments passed. !

//        for (String arg : args.getSourceArgs()) {
//            System.out.println("arg: " + arg);
//        }
//        System.out.println("NonOptionArgs: " + args.getNonOptionArgs()); //[status=running,10]
//        System.out.println("OptionNames: " + args.getOptionNames());  //[mood, 20]
//
//        System.out.println("Printing key and value in loop:");
//        for (String key : args.getOptionNames()) {
//            System.out.println("key: " + key);     //key: mood  //key: 20
//            System.out.println("val: " + args.getOptionValues(key)); //val:[happy] //val:[]
//        }
    }
}