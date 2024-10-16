package khnu.mizhfac;

import khnu.mizhfac.interfaces.Warrior;

class WarriorFactory {
    static Warrior createWarrior(WarriorType type) {
        return switch (type) {
            case WARRIOR -> new SimpleWarrior();
            case KNIGHT -> new Knight();
            case DEFENDER -> new Defender();
            case VAMPIRE -> new Vampire();
        };
    }

    static Warrior createWarrior(String type) {
        return createWarrior(WarriorType.valueOf(
                type.toUpperCase()));
    }
}
