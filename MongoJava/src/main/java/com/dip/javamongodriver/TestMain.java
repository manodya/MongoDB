package com.dip.javamongodriver;

import com.dip.javamongodriver.MongoInstance;
import com.dip.javamongodriver.beans.Address;
import com.dip.javamongodriver.beans.Person;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

/**
 * Hello world!
 */
public class TestMain {
    private static DB database;
    private static DBCollection persons;

    public static void main(String[] args) {
        database = MongoInstance.getDB();

        /**** Get collection ****/
        // if collection doesn't exists, MongoDB will create it for you
        persons =  database.getCollection("persons");
        persons.setObjectClass(Person.class);
        /*********************/

        /**** Insert ****/
        // create a person with values
        Person person1 = new Person("Mano", new Address("Park Street","+94", "Colombo", "Sri Lanka"));
        persons.insert(person1);
        System.out.println(person1.get("_id"));

        //you can insert any kind of  key value pair for any collection
        BasicDBObject tmp = new BasicDBObject();
        tmp.append("foo", "value");
        persons.insert(tmp);

        Person person2 = new Person("Namal", new Address("Main Street", "+94","Matara", "Sri Lanka"));
        persons.insert(person2);

        /******************/

        /**** Find and display ****/
        //find person name = Mano
        Person searchPerson = new Person("Mano");
        DBCursor cursor = persons.find(searchPerson);
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }

        //find persons country = Sri Lanka
        BasicDBObject query = new BasicDBObject();
        query.put("address.country", "Sri Lanka");
        DBCursor cursors = persons.find(query);
        while (cursors.hasNext()) {
            System.out.println(cursors.next());
        }


      //  persons.drop();



    }
}
