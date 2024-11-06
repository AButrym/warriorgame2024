package khnu.mizhfac;

import khnu.mizhfac.interfaces.HasName;
import lombok.Getter;

public class BaseWarriorImpl extends WarriorBase implements HasName {
    private static int idCounter = 0;
    private final int id = ++idCounter;
    @Getter
    private final int attack;
    private String name;

    public BaseWarriorImpl(int health, int attack, String name) {
        super(health);
        this.attack = attack;
        this.name = name;
    }

    @Override
    public String getName() {
        return name + ":" + id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName() + "[h=" + getHealth() + ", a=" + getAttack() + "]";
    }
}
