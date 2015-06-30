package com.dubu;

import com.google.common.collect.Lists;
import junit.framework.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.*;

/**
 * Created by rigel on 6/22/15.
 */
public class JavaUtilTest {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * network test
     */
    @Test
    public void networkTest() {

        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                Enumeration inetAddresses = networkInterface.getInetAddresses();

                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();

                    if (this.logger.isDebugEnabled()) {
                        this.logger.debug(">>> ip: " + inetAddress.getHostAddress());
                    }
//                    throw new Exception("가가가가가");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }
    }


    public enum PrmcMan {
        Doo, Rigel, Mandu
    }

    public class EnumTest {
        PrmcMan man;

        public EnumTest(PrmcMan man) {
            this.man = man;
        }

        public void tellName() {
            switch (man) {
                case Doo:
                    logger.info("DOO");
                    return;

                case Rigel:
                    logger.info("kwak doo");
            }
        }
    }

    @Test
    public void enumTest(){
        EnumTest et = new EnumTest(PrmcMan.Doo);
        et.tellName();

    }


    private <V> V reversObj(V object){

        V rs =  object;
        if(rs instanceof String){
            //return (V) (rs + "dubu");
            return (V) (rs + "Asdfas");
        }else{
            return rs;
        }

    }

    @Test
    public void returnTest(){

        String str = reversObj(new String("AAA"));
        //Integer i = reversObj(new Integer(10));

        logger.info(str);
        //logger.info(i.toString());


    }

    @Test
    public void colVsGuavaTest(){
        List li  = Arrays.asList(1, 2, 3, 2);
        li.add(2423);
//        li.add(2423);   // java.lang.UnsupportedOperationException 발생 size 고정있어 애러 발생;
//        li.add(2423);
//        li.add(2423);

        List guavaLi = Lists.newArrayList(1,2,2,3,4);
        guavaLi.add(100);
        guavaLi.add(100);
        guavaLi.add(100);
        guavaLi.add(100);


        for (Iterator iterator = guavaLi.iterator(); iterator.hasNext(); ) {
            Object next =  iterator.next();
            System.out.println(next);

        }

        for (Iterator iterator = li.iterator(); iterator.hasNext(); ) {
            Object next =  iterator.next();
            System.out.println(next);

        }

    }


    @Test
    public void howToTest(){

        Assert.assertTrue(true);
        Assert.fail();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void expectTest() {

        String[] arrA = {"a", "B"};
        String a = arrA[3];
    }



    @Test
    public void mapTest(){

        // 순서 보장 안함
        Map m1 = new HashMap();
        m1.put("map", "HashMap");
        m1.put("schildt", "java2");
        m1.put("mathew", "Hyden");
        m1.put("schildt", "java2s");
        System.out.println(m1.keySet());
        System.out.println(m1.values());

        // ordering
        SortedMap sm = new TreeMap();
        sm.put("map", "TreeMap");
        sm.put("schildt", "java2");
        sm.put("mathew", "Hyden");
        sm.put("schildt", "java2s");
        System.out.println(sm.keySet());
        System.out.println(sm.values());

        // 넣은대로
        LinkedHashMap lm = new LinkedHashMap();
        lm.put("map", "LinkedHashMap");
        lm.put("schildt", "java2");
        lm.put("mathew", "Hyden");
        lm.put("schildt", "java2s");
        System.out.println(lm.keySet());
        System.out.println(lm.values());

    }





}
