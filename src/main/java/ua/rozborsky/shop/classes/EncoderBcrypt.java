package ua.rozborsky.shop.classes;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import ua.rozborsky.shop.interfaces.Encoder;

/**
 * Created by roman on 14.04.2017.
 */
@Component
public class EncoderBcrypt implements Encoder{
    @Override
    public String code(String password) {

        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    @Override
    public boolean equalsPasswords(String password, String hash) {

        return BCrypt.checkpw(password, hash);
    }
}
