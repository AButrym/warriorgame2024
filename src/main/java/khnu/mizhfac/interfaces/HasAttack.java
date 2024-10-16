package khnu.mizhfac.interfaces;


public interface HasAttack {
    int getAttack();

    default void hit(CanAcceptDamage opponent) {
        opponent.acceptDamage(getAttack());
    }
}
