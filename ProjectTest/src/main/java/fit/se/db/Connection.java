package fit.se.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class Connection {
    private static Connection instance;

    private MongoClient mongoClient;

    private Connection() {
        String uri = "mongodb://localhost:27017";
        mongoClient = MongoClients.create(uri);
    }

    public static Connection getInstance() {
        if (instance == null) {
            instance = new Connection();
        }
        return instance;
    }


    public MongoClient getMongoClient() {
        return mongoClient;
    }
}
