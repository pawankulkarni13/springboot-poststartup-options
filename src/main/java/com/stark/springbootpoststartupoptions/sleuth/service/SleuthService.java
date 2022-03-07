package com.stark.springbootpoststartupoptions.sleuth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SleuthService {

    private static final Logger logger = LoggerFactory.getLogger(SleuthService.class);

    //region Async
    @Async
    public void asyncMethod() throws InterruptedException {
        logger.info("Starting in Async Method");
        Thread.sleep(1000L);
        logger.info("Ending in Async Method");
    }

    //endregion

}
