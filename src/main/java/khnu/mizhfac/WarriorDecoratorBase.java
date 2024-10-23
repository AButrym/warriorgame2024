package khnu.mizhfac;

import khnu.mizhfac.interfaces.Warrior;
import khnu.mizhfac.interfaces.WarriorDecorator;

public abstract class WarriorDecoratorBase implements Warrior, WarriorDecorator {
    private Warrior warrior;

    public WarriorDecoratorBase(Warrior warrior) {
        this.warrior = warrior;
    }

    abstract public Warrior clone();

    @Override
    public void acceptDamage(int damage) {
        warrior.acceptDamage(damage);
    }

    @Override
    public int getAttack() {
        return warrior.getAttack();
    }

    @Override
    public int getHealth() {
        return warrior.getHealth();
    }

    @Override
    public Warrior getWrappedWarrior() {
        return warrior;
    }
}
