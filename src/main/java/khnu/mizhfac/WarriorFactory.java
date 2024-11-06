package khnu.mizhfac;

import khnu.mizhfac.interfaces.Warrior;

import static khnu.mizhfac.WarriorType.*;

public class WarriorFactory {
    static Warrior createWarrior(WarriorType type) {
        return switch (type) {
            case WARRIOR -> new BaseWarriorImpl(WARRIOR.INITIAL_HEALTH, WARRIOR.ATTACK, type.name());
            case KNIGHT -> new BaseWarriorImpl(KNIGHT.INITIAL_HEALTH, KNIGHT.ATTACK, type.name());
            case DEFENDER -> new DefenderDecorator(new BaseWarriorImpl(
                            DEFENDER.INITIAL_HEALTH, DEFENDER.ATTACK, type.name()),
                            DEFENDER.extraProps.get("DEFENCE"));
            case VAMPIRE -> new VampireDecorator(new BaseWarriorImpl(
                            VAMPIRE.INITIAL_HEALTH, VAMPIRE.ATTACK, type.name()),
                            VAMPIRE.extraProps.get("VAMPIRISM"));
        };
    }

    static Warrior createWarrior(String type) {
        return createWarrior(WarriorType.valueOf(
                type.toUpperCase()));
    }
}
