package com.dubu;

import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.time.FastDateFormat;
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

    @Test
    public void dataTest(){
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plusMinutes(10).minusMinutes(dateTime.getMinuteOfHour()%10);
        String date = FastDateFormat.getInstance("yyyy-MM-dd HH:mm").format(dateTime.toDate());
        logger.info(date);

        dateTime = new DateTime(2000, 1, 1, 0, 0, 0, 0);
        logger.info(dateTime.toDate().toString());

    }


    // GsonBuilder 는 추후 계속.

}
