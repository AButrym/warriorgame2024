package khnu.mizhfac;

import java.util.Map;

enum WarriorType {
    WARRIOR(50, 5),
    KNIGHT(50, 7),
    DEFENDER(60, 3, Map.of("DEFENCE", 3)),
    VAMPIRE(40, 4, Map.of("VAMPIRISM", 50)),;

    WarriorType(int initialHealth, int attack) {
        this(initialHealth, attack, Map.of());
    }
    WarriorType(int initialHealth, int attack,
                Map<String, Integer> extraProps) {
        this.INITIAL_HEALTH = initialHealth;
        this.ATTACK = attack;
        this.extraProps = extraProps;
    }

    public final Map<String, Integer> extraProps;
    public final int INITIAL_HEALTH;
    public final int ATTACK;
}
