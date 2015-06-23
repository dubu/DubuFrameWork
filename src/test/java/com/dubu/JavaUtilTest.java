package com.dubu;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import static java.util.Arrays.asList;

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
    public void collectionTest(){
        List li  = asList(1, 2, 3, 2);
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


}
