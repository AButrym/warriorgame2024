package khnu.mizhfac;

public class BaseWarriorImpl extends WarriorBase {
    private int attack;

    public BaseWarriorImpl(int health, int attack) {
        super(health);
        this.attack = attack;
    }

    @Override
    public int getAttack() {
        return attack;
    }
}
