package com.dubu;

import com.google.common.base.Joiner;
import com.google.common.collect.*;
import com.google.gson.Gson;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.provider.certpath.Vertex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by rigel on 6/22/15.
 *
 *
 * 참고
 * https://sites.google.com/site/gson/gson-user-guide
 * https://code.google.com/p/guava-libraries/wiki/RangesExplained
 *
 * 구와바는 소스 코드 다운 받아서 test 코드 부분을 참고합니다.
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


    @Test
    public void joinerTest(){

        Lists.newArrayList("aaaa", "bbbbb" , "ccccc");
        Joiner.on(";").join(Lists.newArrayList("aaaa", "bbbbb", "ccccc"));
        Joiner.on(";").join("aaaa","bbbbb");

    }

    @Test
    public void spiltTest(){

        String str   = "aaabababsdfbksabdkfbskbfk";
        str.split("(a|aa)");

        Pattern ptn = Pattern.compile("[a-z]*");  // intellij regex test

    }


    @Test
    public void tableTest(){
//        Table<Vertex, Vertex, Double> weightedGraph = HashBasedTable.create();
//        weightedGraph.put(v1, v2, 4);
//        weightedGraph.put(v1, v3, 20);
//        weightedGraph.put(v2, v3, 5);
//
//        weightedGraph.row(v1); // returns a Map mapping v2 to 4, v3 to 20
//        weightedGraph.column(v3); // returns a Map mapping v1 to 20, v2 to 5
    }

    @Test
    public void afds(){
        List<? extends Integer> aa = Lists.newArrayList(1,2,3,3);
        for (int i = 0; i < aa.size(); i++) {
             Integer integer =  aa.get(i);
            logger.info(integer.toString());

        }
    }
}
