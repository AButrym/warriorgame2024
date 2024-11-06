package khnu.mizhfac.interfaces;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public interface HasAttack {
    Logger log = LoggerFactory.getLogger(HasAttack.class);

    int getAttack();

    default void hit(CanAcceptDamage opponent) {
        log.debug("{} hits {}", this, opponent);
        opponent.acceptDamage(getAttack());
    }
}
