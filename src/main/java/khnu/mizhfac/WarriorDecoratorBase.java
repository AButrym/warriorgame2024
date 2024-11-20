package khnu.mizhfac;

import khnu.mizhfac.interfaces.CanAcceptDamage;
import khnu.mizhfac.interfaces.Warrior;
import khnu.mizhfac.interfaces.WarriorDecorator;
import lombok.Getter;

@Getter
public abstract class WarriorDecoratorBase implements Warrior, WarriorDecorator {
    private final Warrior wrappedWarrior;

    public WarriorDecoratorBase(Warrior warrior) {
        this.wrappedWarrior = warrior;
    }

    abstract public Warrior clone();

    @Override
    public void acceptDamage(int damage) {
        wrappedWarrior.acceptDamage(damage);
    }

    @Override
    public int getAttack() {
        return wrappedWarrior.getAttack();
    }

    @Override
    public int getHealth() {
        return wrappedWarrior.getHealth();
    }

    @Override
    public String toString() {
        return getWrappedWarrior().toString();
    }

    @Override
    public void hit(CanAcceptDamage opponent) {
        wrappedWarrior.hit(opponent);
    }

    @Override
    public void heal(int healPoints) {
        wrappedWarrior.heal(healPoints);
    }
}
