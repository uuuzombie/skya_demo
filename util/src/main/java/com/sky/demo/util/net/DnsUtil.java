package com.sky.demo.util.net;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by rg on 2016/2/17.
 */
public class DnsUtil {

    private static String localHost;        //ubuntu/127.0.0.1
    private static String hostAddress;      //127.0.0.1
    private static String hostName;         //ubuntu
    private static byte[] rawAddress = new byte[4];

    static {

        try {
            localHost = InetAddress.getLocalHost().toString();
            hostAddress = Inet4Address.getLocalHost().getHostAddress();
            hostName = InetAddress.getLocalHost().getHostName();
            rawAddress = InetAddress.getLocalHost().getAddress();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    public static String getLocalHost() {
        return localHost;
    }

    public static String getHostAddress() {
        return hostAddress;
    }

    public static String getHostName() {
        return hostName;
    }

    public static byte[] getRawAddress() {
        return rawAddress;
    }
}
