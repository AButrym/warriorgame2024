package khnu.mizhfac;

public class Warrior {
    static final int attack = 5;
    private int health = 50;

    public boolean isAlive() {
        return health > 0;
    }

    public int getAttack() {
        return attack;
    }

    int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    public void hit(Warrior opponent) {
        var currentHealth = opponent.getHealth();
        var reducedHealth = currentHealth - getAttack();
        opponent.setHealth(reducedHealth);
    }
}
