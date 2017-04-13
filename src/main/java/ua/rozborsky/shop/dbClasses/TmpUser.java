package ua.rozborsky.shop.dbClasses;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Transient;
import org.springframework.context.annotation.Scope;

/**
 * Created by roman on 09.03.2017.
 */
@Entity("wait_confirm")
@Scope(value="prototype")
public class TmpUser extends User {
    @Transient
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
