package com.dubu;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rigel on 6/22/15.
 *
 *
 * 참고 https://sites.google.com/site/gson/gson-user-guide
 *
 */
public class GoogleUtilTest {

    protected Logger logger = LoggerFactory.getLogger(getClass());


    @Test
    public void googleTypeTest() {

        List<String> commitLogList = Lists.newArrayList("AA", "BB", "AA");
        commitLogList = Lists.newArrayList(Sets.newLinkedHashSet(commitLogList));
        StringBuffer buffer = new StringBuffer();
        for (String log : commitLogList) {
            buffer.append(log.trim() + "<br>");
        }

        logger.info(buffer.toString());

    }

    @Test
    public void gsonTest() {

        CommentTotalCount c = new CommentTotalCount();
        HashMap<String,Long> m = Maps.newHashMap();
        m.put("aa", 100L);
        m.put("bb", 200L);

        c.setTotalCount(m);

        Gson g = new Gson();
        logger.info(g.toJson(c));


        String strJson = g.toJson(c);
        CommentTotalCount obj  = g.fromJson(strJson, CommentTotalCount.class);
        logger.info(obj.toString());
    }


    static class CommentTotalCount {
        private Map<String, Long> totalCount;

        public Map<String, Long> getTotalCount() {
            return totalCount;
        }

        public Long getCommentCount(String docId) {
            Long value = this.totalCount.get(docId);

            if (value == null) {
                return 0L;
            }

            if (value < 0) {
                return 0L;
            }

            return value;
        }

        public void setTotalCount(Map<String, Long> totalCount) {
            this.totalCount = totalCount;
        }
    }
}
