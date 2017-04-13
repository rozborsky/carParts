package ua.rozborsky.shop.interfaces;

/**
 * Created by roman on 14.04.2017.
 */
public interface Encoder {
    String code(String password);
    boolean equalsPasswords(String password, String hash);
}
