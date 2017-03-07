package ua.rozborsky.shop.classes;

import com.mongodb.*;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.stereotype.Component;
import ua.rozborsky.shop.interfaces.DAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roman on 19.11.2016.
 */
@Component
public class DAOImpl implements DAO {
    private MongoClient mc;
    private Morphia morphia;

    public DAOImpl(){
        mc = new MongoClient("localhost", 27017);
        morphia =  new Morphia();
        DB database = mc.getDB("Examples");

        DBObject person = new BasicDBObject()
                .append("name", "Jo Bloggs")
                .append("address", new BasicDBObject("street", "123 Fake St")
                        .append("city", "Faketon")
                        .append("state", "MA")
                        .append("zip", 12345))
                .append("books", "ggg");

        try {

            final Datastore datastore = morphia.createDatastore(mc, "morphia_examplet");
            datastore.ensureIndexes();
            datastore.save(person);

            DBCollection collection = database.getCollection("people");
            collection.insert(person);
        }
        catch (Exception e) {
            throw new RuntimeException("Error initializing mongo db", e);
        }


    }

    public Datastore createDatastore(String database){
        Datastore ds=morphia.createDatastore(mc,database);
        ds.ensureIndexes();
        ds.ensureCaps();
        return ds;
    }

    @Override
    public void saveValues() {

    }
}
