package com.sky.demo.common.serialize.util;


import com.sky.demo.common.serialize.bean.User;

import java.io.*;

public class UserUtil {

    public static void writeToFile(User src,String dataFile){
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        FileOutputStream fos = null;

        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            fos = new FileOutputStream(dataFile);

            os.writeObject(src);
            os.flush();

            byte[] b = bos.toByteArray();

            fos.write(b);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                bos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static User readFromFile(String dataFile){
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(dataFile);
            ois = new ObjectInputStream(fis);
            User user = (User)ois.readObject();

            return user;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
