package ua.rozborsky.shop.classes;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by roman on 21.04.2017.
 */
@Component
@Entity("categories")
@Scope(value="prototype")
public class Category {

    @Id
    @Property("id")
    private ObjectId id;
    private String name;
    private String image;
    private String description;
    private boolean active;


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
