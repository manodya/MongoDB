package com.dip.javamongodriver;

import com.dip.utils.MongoJavaUtils;
import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * Created by manodyas on 11/17/2016.
 */
public class MongoInstance {

    private static MongoClient mongoClient = null;
    private static DB mongoDB = null;

    public static DB getDB() {
        if (mongoDB == null) {
            /**** Connect to MongoDB ****/
            mongoClient = new MongoClient(MongoJavaUtils.getConfiguration("serverIP"), Integer.parseInt(MongoJavaUtils.getConfiguration("port")));
            /**** Get database ****/
            // if database doesn't exists, MongoDB will create it for you
            mongoDB = mongoClient.getDB(MongoJavaUtils.getConfiguration("db"));
        }
        return mongoDB;
    }
}

