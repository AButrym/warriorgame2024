package khnu.mizhfac;

enum WarriorType {
    WARRIOR, KNIGHT;
}

class WarriorFactory {
    static Warrior createWarrior(WarriorType type) {
        return switch (type) {
            case WARRIOR -> new Warrior();
            case KNIGHT -> new Knight();
        };
    }
    static Warrior createWarrior(String type) {
        return switch (type.toUpperCase()) {
            case "WARRIOR" -> new Warrior();
            case "KNIGHT" -> new Knight();
            default -> throw new IllegalArgumentException(
                    "Unknown type: " + type);
        };
    }
    static Warrior createWarrior(Class<? extends Warrior> type) {
        return createWarrior(type.getSimpleName().toUpperCase());
    }
}

public class Army {
    public Army addUnits(
            Class<? extends Warrior> type,
            int howMany
    ) {
        Warrior warrior = WarriorFactory.createWarrior(type);
        // TODO
        return this;
    }
}
