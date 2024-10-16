package khnu.mizhfac.interfaces;

public interface HasHealth {
    int getHealth();

    default boolean isAlive() {
        return getHealth() > 0;
    }
}
