package ua.rozborsky.shop.classes;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by roman on 12.04.2017.
 */
@Component
public class TimeManager {
    public long getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis()).getTime();
    }
}
