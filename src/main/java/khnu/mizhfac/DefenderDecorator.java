package khnu.mizhfac;

import khnu.mizhfac.interfaces.HasDefence;
import khnu.mizhfac.interfaces.Warrior;


public class DefenderDecorator extends WarriorDecoratorBase implements Warrior, HasDefence {
    private final int defence;

    public DefenderDecorator(Warrior warrior, int defence) {
        super(warrior);
        this.defence = defence;
    }

    @Override
    public int getDefence() {
        return defence;
    }

    @Override
    public Warrior clone() {
        return new DefenderDecorator(getWrappedWarrior().clone(), defence);
    }

    @Override
    public void acceptDamage(int damage) {
        int reducedDamage = Math.max(0, damage - getDefence());
        getWrappedWarrior().acceptDamage(reducedDamage);
    }
}