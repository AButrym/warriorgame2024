package khnu.mizhfac.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface HasHealth {
    Logger log = LoggerFactory.getLogger(HasHealth.class);

    int getHealth();

    default boolean isAlive() {
        var res = getHealth() > 0;
        if (!res) log.debug("{} is dead", this);
        return res;
    }
}
