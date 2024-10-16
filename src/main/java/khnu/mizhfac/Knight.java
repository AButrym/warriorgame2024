package khnu.mizhfac;

import static khnu.mizhfac.WarriorType.KNIGHT;

public class Knight extends WarriorBase {
    public Knight() {
        super(KNIGHT.INITIAL_HEALTH);
    }

    @Override
    public int getAttack() {
        return KNIGHT.ATTACK;
    }
}
