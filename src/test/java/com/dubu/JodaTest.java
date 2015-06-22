package com.dubu;

import org.joda.time.DateTime;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rigel on 6/22/15.
 */
public class JodaTest {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void timeGenTest(){

        DateTime dateTime = new DateTime();
        dateTime = dateTime.withTime(0, 0, 0, 0);
        logger.info(dateTime.toString());

    }

}
