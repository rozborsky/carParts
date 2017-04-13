package ua.rozborsky.shop.interfaces;

import ua.rozborsky.shop.dbClasses.TmpUser;
import ua.rozborsky.shop.dbClasses.User;

/**
 * Created by roman on 06.03.2017.
 */
public interface DAO {
    void saveUser(User person);
    TmpUser getUser(long timestamp);
    void registerUser(TmpUser person);
}
