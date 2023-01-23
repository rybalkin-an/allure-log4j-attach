package de.rhenus.com.allure;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class SampleTest implements Attachment{

    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger("myLogger");

    @Test
    public void testOne() {
        log.info("test 1");
        log.info("============== START ===============");
        log.info("Step 1: do something");
        log.info("Step 2: do something");
        log.info("=============== END ================");
    }

    @Test
    public void testTwo() {
        log.info("test 2");
        log.info("============== START ===============");
        log.info("Step 1: do something");
        fail();
        log.info("Step 2: do something");
        log.info("=============== END ================");
    }
}
