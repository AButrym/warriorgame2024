package khnu.mizhfac;

public class Defender extends Warrior {
    static final int INITIAL_HEALTH = 60;
    static final int ATTACK = 3;
    static final int DEFENCE = 2;

    /*  health = 60
        attack = 3
        defense = 2
        */

    public Defender() {
        super(INITIAL_HEALTH);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getDefence() {
        return DEFENCE;
    }

    @Override
    protected void acceptDamage(int damage) {
        int reducedDamage = Math.max(0, damage - getDefence());
        super.acceptDamage(reducedDamage);
    }
}
