package ua.rozborsky.shop.classes;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.rozborsky.shop.interfaces.DAO;
import ua.rozborsky.shop.interfaces.Person;


/**
 * Created by roman on 19.11.2016.
 */
@Component
public class DAOImpl implements DAO {
    private Morphia morphia;
    private MongoClient mongo;
    private Datastore datastore;

    @Autowired
    TimeManager timeManager;

    public DAOImpl(){
        morphia = new Morphia();
        morphia.mapPackage("ua.rozborsky.shop.dbClasses");
        mongo = new MongoClient();
        datastore = morphia.createDatastore(mongo, "car_parts");
        datastore.ensureIndexes();
    }


    @Override
    public void savePerson(Person person) {
        person.setTimestamp(timeManager.getCurrentTimestamp());
        datastore.save(person);
    }
}
