package com.stark.springbootpoststartupoptions.sleuth;

import brave.Span;
import brave.Tracer;
import com.stark.springbootpoststartupoptions.sleuth.service.SleuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;

@RestController
public class SleuthFunctionalityDemoRestController {
    private static final Logger logger = LoggerFactory.getLogger(SleuthFunctionalityDemoRestController.class);

    @Autowired
    private Tracer tracer;

    @Autowired
    private Executor executor;

    @Autowired
    private SleuthService asyncService;


    @GetMapping("/traceid")
    public String getSleuthTraceId() throws InterruptedException {
        logger.info("Hello from Pawan - with Sleuth");
        Span span = tracer.currentSpan();

        if (span != null) {
            logger.info("Trace ID {}", span.context().traceId());
            logger.info("Span ID {}", span.context().spanId());
        }


        logger.info("I'm in the original span for request !!");

        Span newSpan = tracer.nextSpan().name("myNewSpan").start();
        try (brave.Tracer.SpanInScope spanScope = tracer.withSpanInScope(newSpan.start())) {
            Thread.sleep(1000L);
            logger.info("I'm in the new span which has its own span");
        } finally {
            newSpan.finish();
        }

        logger.info("I'm still in the original span for request !!");

        return "Hello from Pawan - with Sleuth";
    }

    @GetMapping("/traceid/thread")
    public String helloSleuthNewThread() {
        logger.info("Hello from New Thread");
        Runnable runnable = () -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("I'm inside the new thread - with a new span");
        };
        executor.execute(runnable);

        logger.info("I'm with the original span");
        return "success";
    }

    @GetMapping("/traceid/async")
    public String sleuthAsync() throws InterruptedException {
        logger.info("Before - Async Method");
        asyncService.asyncMethod();
        logger.info("After - Async Method");

        return "success";
    }

}
