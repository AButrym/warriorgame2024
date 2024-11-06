package khnu.mizhfac;

import khnu.mizhfac.interfaces.CanHealSelf;
import khnu.mizhfac.interfaces.Warrior;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j(topic = "WarriorBase")
public abstract class WarriorBase implements Warrior, CanHealSelf {
    @Getter private int health;
    private final int initialHealth;

    protected WarriorBase(int health) {
        this.health = health;
        initialHealth = health;
    }

    private void setHealth(int health) {
        this.health = Math.min(health, initialHealth);
        log.debug("{} setHealth: {}", this, getHealth());
    }

    public void acceptDamage(int damage) {
        setHealth(getHealth() - damage);
    }

    public void heal(int healPoints) {
        log.debug("{} heals self by {} points", this, healPoints);
        setHealth(getHealth() + healPoints);
    }

    @Override
    public Warrior clone() {
        try {
            return (Warrior) super.clone();
        } catch (CloneNotSupportedException e) {
            return null; // you'll never get here
        }
    }
}