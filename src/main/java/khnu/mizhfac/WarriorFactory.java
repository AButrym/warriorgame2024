package khnu.mizhfac;

import khnu.mizhfac.interfaces.Warrior;

import static khnu.mizhfac.WarriorType.*;

class WarriorFactory {
    static Warrior createWarrior(WarriorType type) {
        return switch (type) {
            case WARRIOR -> new BaseWarriorImpl(WARRIOR.INITIAL_HEALTH, WARRIOR.ATTACK);
            case KNIGHT -> new BaseWarriorImpl(KNIGHT.INITIAL_HEALTH, KNIGHT.ATTACK);
            case DEFENDER -> new DefenderDecorator(new BaseWarriorImpl(
                    DEFENDER.INITIAL_HEALTH, DEFENDER.ATTACK),
                    DEFENDER.extraProps.get("DEFENCE"));
            case VAMPIRE -> new VampireDecorator(new BaseWarriorImpl(
                    VAMPIRE.INITIAL_HEALTH, VAMPIRE.ATTACK),
                    VAMPIRE.extraProps.get("VAMPIRISM"));
        };
    }

    static Warrior createWarrior(String type) {
        return createWarrior(WarriorType.valueOf(
                type.toUpperCase()));
    }
}
