package com.dip.javamongodriver.beans;

import com.mongodb.BasicDBObject;

/**
 * Created by manodyas on 11/17/2016.
 */
public class Person extends BasicDBObject {
    public Person(){
    }
    public Person(String fullName, Address address){
        put("name", fullName);
        put("address", address);
    }

    public Person(String fullName){
        put("name", fullName);
    }

    public Person(Address address){
        put("address", address);
    }
}
