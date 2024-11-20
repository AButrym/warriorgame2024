package khnu.mizhfac;

import khnu.mizhfac.interfaces.CanHeal;
import khnu.mizhfac.interfaces.CanHealSelf;

public class Healer extends BaseWarriorImpl implements CanHeal {
    private int healPower;

    public Healer(String name) {
        super(WarriorType.HEALER.INITIAL_HEALTH,
                WarriorType.HEALER.ATTACK, name);
        healPower = WarriorType.HEALER.extraProps.get("HEAL_POWER");
    }

    @Override
    public void heal(CanHealSelf patient) {
        patient.heal(healPower);
    }
}
