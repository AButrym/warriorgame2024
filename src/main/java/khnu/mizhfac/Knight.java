package khnu.mizhfac;

public class Knight extends Warrior {
    static final int INITIAL_HEALTH = 50;
    static final int ATTACK = 7;

    public Knight() {
        super(INITIAL_HEALTH);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }
}
