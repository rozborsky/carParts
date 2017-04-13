package ua.rozborsky.shop.dbClasses;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by roman on 09.03.2017.
 */
@Entity("users")
public class User {
    @Id
    @Property("id")
    protected ObjectId id;

    @NotEmpty(message="вкажіть ім'я")
    @Size(min = 2, max = 20, message="ім'я повинно бути довжиною не від 2-х до 20-и символів")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я'ії]*$", message="неправильний формат імені")
    private String name;

    @NotEmpty(message="вкажіть прізвище")
    @Size(min = 2, max = 20, message="прізвище повинно бути довжиною не від 2-х до 30-и символів")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я'ії]*$", message="неправильний формат прізвища")
    private String surname;

    @Pattern(regexp = "\\d*", message="лише цифри")
    private String phone;

    @NotEmpty(message="вкажіть e-mail")
    @Email(message="невірний формат e-mail")
    private String eMail;

    private String address;

    @NotEmpty(message="вкажіть пароль")
    @Size(min = 6, max = 15, message="пароль повинен бути довжиною не менше 6-х і не більше 15-и символів")
    private String password;


    private long timestamp;


    public Object getId() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
