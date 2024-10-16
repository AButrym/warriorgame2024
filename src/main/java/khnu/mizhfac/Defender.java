package khnu.mizhfac;

import static khnu.mizhfac.WarriorType.DEFENDER;

public class Defender extends WarriorBase {
    public Defender() {
        super(DEFENDER.INITIAL_HEALTH);
    }

    @Override
    public int getAttack() {
        return DEFENDER.ATTACK;
    }

    public int getDefence() {
        return DEFENDER.extraProps.get("DEFENCE");
    }

    @Override
    public void acceptDamage(int damage) {
        int reducedDamage = Math.max(0, damage - getDefence());
        super.acceptDamage(reducedDamage);
    }
}
