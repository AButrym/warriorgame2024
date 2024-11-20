package khnu.mizhfac;

import khnu.mizhfac.interfaces.Warrior;

import java.util.Map;

public enum WarriorType {
    WARRIOR(50, 5),
    KNIGHT(50, 7),
    DEFENDER(60, 3, Map.of("DEFENCE", 2)),
    VAMPIRE(40, 4, Map.of("VAMPIRISM", 50)),
    LANCER(50, 6),
    HEALER(60, 0, Map.of("HEAL_POWER", 2))
    ;

    WarriorType(int initialHealth, int attack) {
        this(initialHealth, attack, Map.of());
    }
    WarriorType(int initialHealth, int attack,
                Map<String, Integer> extraProps) {
        this.INITIAL_HEALTH = initialHealth;
        this.ATTACK = attack;
        this.extraProps = extraProps;
    }

    public Warrior create() {
        return WarriorFactory.createWarrior(this);
    }

    public final Map<String, Integer> extraProps;
    public final int INITIAL_HEALTH;
    public final int ATTACK;
}
