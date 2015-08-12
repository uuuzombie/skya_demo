package com.sky.demo.util.net;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by rg on 2015/7/21.
 */
public class HttpUtil {

    /**
     * 获取用户ip地址
     * @param request
     */
    public static String getIpAddr(HttpServletRequest request) {

        String ip = request.getHeader("X-Real-IP");
        if (StringUtils.isNotBlank(ip) && !StringUtils.equalsIgnoreCase("unknown",ip)) {
            return ip;
        }

        ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotBlank(ip) && !StringUtils.equalsIgnoreCase("unknown",ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }




    public static String getServerIp() {
        String serverIp = null;
        try {
            Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
                ip = (InetAddress) ni.getInetAddresses().nextElement();
                serverIp = ip.getHostAddress();

                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                    serverIp = ip.getHostAddress();
                    break;
                } else {
                    ip = null;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        return serverIp;
    }

    public static String getLocalIp() {
        String ipAddrStr = "";
        try {
            InetAddress addr = InetAddress.getLocalHost();

//            byte[] ipAddr = addr.getAddress();
//            for (int i = 0; i < ipAddr.length; i++) {
//                if (i > 0) {
//                    ipAddrStr += ".";
//                }
//                ipAddrStr += ipAddr[i] & 0xFF;
//            }

            ipAddrStr = addr.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ipAddrStr;
    }




}
