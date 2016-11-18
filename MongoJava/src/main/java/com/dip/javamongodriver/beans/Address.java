package com.dip.javamongodriver.beans;

import com.mongodb.BasicDBObject;

/**
 * Created by manodyas on 11/17/2016.
 */
public class Address extends BasicDBObject {
    public Address(){
    }
    public Address(String streetName, String postalCode, String place, String country){
        put("street", streetName);
        put("postalCode", postalCode);
        put("place", place);
        put("country", country);
    }

    public Address(String country){
        put("country", country);
    }
    public String Place(){
        return (String) get("place");
    }
}
