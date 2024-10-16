package khnu.mizhfac;

// SOLID

import static khnu.mizhfac.WarriorType.WARRIOR;

public class SimpleWarrior extends WarriorBase {
    public SimpleWarrior() {
        super(WARRIOR.INITIAL_HEALTH);
    }

    public int getAttack() {
        return WARRIOR.ATTACK;
    }
}
