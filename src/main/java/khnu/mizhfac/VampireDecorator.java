package khnu.mizhfac;

import khnu.mizhfac.interfaces.*;
import lombok.Getter;

@Getter
public class VampireDecorator extends WarriorDecoratorBase implements Warrior, HasVampirism {
    private final int vampirism;

    public VampireDecorator(Warrior warrior, int vampirism) {
        super(warrior);
        this.vampirism = vampirism;
    }

    @Override
    public Warrior clone() {
        return new VampireDecorator(getWrappedWarrior().clone(), vampirism);
    }

    @Override
    public void hit(CanAcceptDamage opponent) {
        int healthBefore = opponent.getHealth();
        getWrappedWarrior().hit(opponent);
        int healthAfter = opponent.getHealth();
        int selfHealing = (healthBefore - healthAfter) * getVampirism() / 100;
        Warrior warrior = getWrappedWarrior();
        while (warrior instanceof WarriorDecorator warriorDecorator) {
            if (warrior instanceof CanHealSelf) break;
            warrior = warriorDecorator.getWrappedWarrior();
        }
        if (warrior instanceof CanHealSelf warriorBase) {
            warriorBase.heal(selfHealing);
        } else {
            throw new IllegalStateException("Vampire should be able to heal himself");
        }
    }
}
