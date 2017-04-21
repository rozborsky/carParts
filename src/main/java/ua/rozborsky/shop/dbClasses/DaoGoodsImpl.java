package ua.rozborsky.shop.dbClasses;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.stereotype.Component;
import ua.rozborsky.shop.classes.Category;
import ua.rozborsky.shop.interfaces.DaoGoods;

import java.util.List;

/**
 * Created by roman on 21.04.2017.
 */
@Component
public class DaoGoodsImpl implements DaoGoods{

    private Morphia morphia;
    private MongoClient mongo;
    private Datastore datastore;

    public DaoGoodsImpl(){
        morphia = new Morphia();
        morphia.mapPackage("ua.rozborsky.shop.dbClasses");
        mongo = new MongoClient();
        datastore = morphia.createDatastore(mongo, "car_parts");
        //datastore.ensureIndexes();
    }

    @Override
    public List<Category> getCategories() {

        return datastore.createQuery(Category.class).asList();
    }

    @Override
    public Category getCategory() {
        return null;
    }

    @Override
    public void addCategory(Category category) {
        datastore.save(category);
    }
}
