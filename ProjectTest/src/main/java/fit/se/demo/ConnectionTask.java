package fit.se.demo;

import com.mongodb.client.MongoClient;

import fit.se.db.Connection;

public class ConnectionTask {
    public static void main(String[] args) {
        
       MongoClient clients = Connection.getInstance().getMongoClient();
       clients.listDatabaseNames().forEach(System.out::println);

    }
}
