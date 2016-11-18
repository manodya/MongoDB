package com.dip.utils;

import com.mongodb.MongoClient;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by manodyas on 11/17/2016.
 */
public class MongoJavaUtils {

    public static String getConfiguration(String propertyName) {
        String jndi = null;
        InputStream is = null;
        try {
            String sSettingsFile = "/Mongo.properties";
            Properties g_oProperties = new Properties();
            is = MongoJavaUtils.class.getResourceAsStream(sSettingsFile);
            g_oProperties.load(is);
            jndi = String.valueOf(g_oProperties.get(propertyName)).trim();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Exception e) {
            }
        }
        return jndi;
    }

}
