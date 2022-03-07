package com.stark.springbootpoststartupoptions.sleuth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulingService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SleuthService sleuthService;

    //region Schedule Support

    @Scheduled(fixedDelay = 30000)
    public void scheduledWork() throws InterruptedException {
        logger.info("Starting scheduled work from the scheduled task");
        sleuthService.asyncMethod();
        logger.info("Ending work from scheduled task");
    }
    //endregion
}
