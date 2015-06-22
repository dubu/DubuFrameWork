package com.dubu;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Created by rigel on 6/22/15.
 */
public class JavaCoreTest {

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


}
