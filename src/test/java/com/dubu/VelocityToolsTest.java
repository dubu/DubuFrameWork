package com.dubu;

import org.apache.velocity.tools.generic.LinkTool;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by rigel on 6/22/15.
 * <p/>
 * <p/>
 * linktools
 */
public class VelocityToolsTest {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void linkToolsTest() {
        String videoUrl = "http://www.dubu.daum.net?id=dubu&pw=1234";
        LinkTool linkTool = new LinkTool().absolute(videoUrl);
        Map map = linkTool.getParams();
        logger.info((String) map.get("id"));
    }


}
