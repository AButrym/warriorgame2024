package khnu.mizhfac;

import khnu.mizhfac.interfaces.CanAcceptDamage;
import khnu.mizhfac.interfaces.HasWarriorBehind;
import khnu.mizhfac.interfaces.Warrior;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lancer extends BaseWarriorImpl {
    public Lancer(String name) {
        super(WarriorType.LANCER.INITIAL_HEALTH,
                WarriorType.LANCER.ATTACK, name);
    }

    @Override
    public void hit(CanAcceptDamage opponent) {
        log.debug("Lancer hits {}", opponent);
        final int penetrationPowerPercentage = 50;
        var currenHealth = opponent.getHealth();
        super.hit(opponent);

        if (opponent instanceof HasWarriorBehind warriorWithBacker) {
            log.trace("Lancer's opponent implements HasWarriorBehind");
            Warrior warriorBehind = warriorWithBacker.getWarriorBehind();
            if (warriorBehind == null) return;
            var dealtDamage = currenHealth - opponent.getHealth();
            var damageForTheNext = dealtDamage * penetrationPowerPercentage / 100;
            log.debug("Lancer hits the second warrior {}", warriorBehind);
            warriorBehind.acceptDamage(damageForTheNext);
        }
    }
}
