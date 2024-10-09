package khnu.mizhfac;

public class Warrior implements Cloneable {
    static final int ATTACK = 5;
    static final int INITIAL_HEALTH = 50;
    private int health;
    private final int initialHealth;

    protected Warrior(int health) {
        this.health = health;
        initialHealth = health;
    }

    public Warrior() {
        this(INITIAL_HEALTH);
    }

    @Override
    public Warrior clone() {
        try {
            return (Warrior) super.clone();
        } catch (CloneNotSupportedException e) {
            return null; // you'll never get here
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getAttack() {
        return ATTACK;
    }

    int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        this.health = Math.min(health, initialHealth);
    }

    protected void heal(int healPoints) {
        setHealth(getHealth() + healPoints);
    }

    public void hit(Warrior opponent) {
        opponent.acceptDamage(getAttack());
    }

    protected void acceptDamage(int damage) {
        setHealth(getHealth() - damage);
    }
}
