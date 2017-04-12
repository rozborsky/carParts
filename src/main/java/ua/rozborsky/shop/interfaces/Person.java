package ua.rozborsky.shop.interfaces;

/**
 * Created by roman on 09.03.2017.
 */
public interface Person {

    String getName();
    void setName(String name);

    String getSurname();

    void setSurname(String surname);

    String getPhone();

    void setPhone(String phone);

    String geteMail();

    void seteMail(String eMail);

    String getAddress();

    void setAddress(String address);

    String getPassword();

    void setPassword(String password);

    String getConfirmPassword();

    void setConfirmPassword(String confirmPassword);

    long getTimestamp();

    void setTimestamp(long timestamp);
}
