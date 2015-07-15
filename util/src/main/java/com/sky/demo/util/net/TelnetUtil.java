package com.sky.demo.util.net;

import org.apache.commons.net.telnet.TelnetClient;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by rg on 7/15/15.
 */
public class TelnetUtil {

    private TelnetClient telnet = new TelnetClient();

    private InputStream in;

    private PrintStream out;

    /**
     * Linux缺省结束符
     */
    private static final String DEFAULT_AIX_PROMPT = "#";

    /**
     * 缺省端口
     */
    private static final int DEFAULT_TELNET_PORT = 23;


    /**
     * IP 地址
     */
    private String ip;

    /**
     * telnet 端口
     */
    private String port;

    /**
     * 用户名
     */
    private String user;

    /**
     * 密码
     */
    private String password;


    public TelnetUtil(String ip, String user, String password) {
        this.ip = ip;
        this.port = String.valueOf(TelnetUtil.DEFAULT_TELNET_PORT);
        this.user = user;
        this.password = password;
    }

    public TelnetUtil(String ip, String port, String user, String password) {
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    /**
     * @return boolean 连接成功返回true，否则返回false
     */
    private boolean connect() {
        boolean isConnect = true;

        try {
            telnet.connect(ip, Integer.parseInt(port));

            in = telnet.getInputStream();
            out = new PrintStream(telnet.getOutputStream());

            /** Log the user on* */
            readUntil("login: ");
            write(user);

            readUntil("Password: ");
            write(password);

            /** Advance to a prompt */
            readUntil(DEFAULT_AIX_PROMPT);

        } catch (Exception e) {
            isConnect = false;
            e.printStackTrace();
            return isConnect;
        }
        return isConnect;
    }

    public void su(String user, String password) {
        try {
            write("su" + " - " + user);
            readUntil("Password:");
            write(password);
            readUntil(DEFAULT_AIX_PROMPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readUntil(String pattern) {
        try {
            char lastChar = pattern.charAt(pattern.length() - 1);
            StringBuffer sb = new StringBuffer();
            char ch = (char) in.read();
            while (true) {
                //System.out.print(ch);// ---需要注释掉
                sb.append(ch);
                if (ch == lastChar) {
                    if (sb.toString().endsWith(pattern)) {
                        return sb.toString();
                    }
                }
                ch = (char) in.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void write(String value) {
        try {
            out.println(value);
            out.flush();
            //System.out.println(value);// ---需要注释掉
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String sendCommand(String command) {
        try {
            write(command);
            return readUntil(DEFAULT_AIX_PROMPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private void disconnect() {
        try {
            telnet.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try {
            TelnetUtil telnet = new TelnetUtil("ip", "username", "password");
//            String ls = telnet.sendCommand("ls");

            telnet.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
