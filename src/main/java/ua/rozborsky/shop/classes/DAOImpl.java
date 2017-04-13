package ua.rozborsky.shop.classes;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Component;
import ua.rozborsky.shop.dbClasses.TmpUser;
import ua.rozborsky.shop.dbClasses.User;
import ua.rozborsky.shop.interfaces.DAO;


/**
 * Created by roman on 19.11.2016.
 */
@Component
public class DAOImpl implements DAO {

    private Morphia morphia;
    private MongoClient mongo;
    private Datastore datastore;

    public DAOImpl(){
        morphia = new Morphia();
        morphia.mapPackage("ua.rozborsky.shop.dbClasses");
        mongo = new MongoClient();
        datastore = morphia.createDatastore(mongo, "car_parts");
        datastore.ensureIndexes();
    }


    @Override
    public void saveUser(User user) {
        datastore.save(user);
    }

    @Override
    public TmpUser getUser(long timestamp) {
        TmpUser user = datastore.find(TmpUser.class)
                .field("timestamp").equal(timestamp).get();//todo exception?

        return user;
    }

    @Override
    public void registerUser(TmpUser tmpUser) {
        removeUser(tmpUser.getTimestamp());

        User user = new User();
        user.setName(tmpUser.getName());
        user.setSurname(tmpUser.getSurname());
        user.setPhone(tmpUser.getPhone());
        user.setAddress(tmpUser.getAddress());
        user.seteMail(tmpUser.geteMail());
        user.setPassword(tmpUser.getPassword());
        user.setTimestamp(tmpUser.getTimestamp());

        saveUser(user);
    }

    private void removeUser(long timestamp) {
        final Query<TmpUser> removeUser = datastore.createQuery(TmpUser.class)
                .filter("timestamp =", timestamp);
        datastore.delete(removeUser);
    }
}
