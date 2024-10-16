package khnu.mizhfac;

import khnu.mizhfac.interfaces.Warrior;

public class Vampire extends Warrior {
    static final int INITIAL_HEALTH = 40;
    static final int ATTACK = 4;
    static final int VAMPIRISM = 50;

    public Vampire() {
        super(INITIAL_HEALTH);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getVampirism() {
        return VAMPIRISM;
    }

    @Override
    public void hit(Warrior opponent) {
        int healthBefore = opponent.getHealth();
        super.hit(opponent);
        int healthAfter = opponent.getHealth();
        int selfHealing = (healthBefore - healthAfter) * getVampirism() / 100;
        heal(selfHealing);
    }
}
