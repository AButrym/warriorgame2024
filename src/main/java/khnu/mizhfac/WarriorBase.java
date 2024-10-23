package khnu.mizhfac;

import khnu.mizhfac.interfaces.CanHealSelf;
import khnu.mizhfac.interfaces.Warrior;

public abstract class WarriorBase implements Warrior, CanHealSelf {
    private int health;
    private final int initialHealth;

    protected WarriorBase(int health) {
        this.health = health;
        initialHealth = health;
    }

    @Override
    public int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        this.health = Math.min(health, initialHealth);
    }

    public void acceptDamage(int damage) {
        setHealth(getHealth() - damage);
    }

    public void heal(int healPoints) {
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