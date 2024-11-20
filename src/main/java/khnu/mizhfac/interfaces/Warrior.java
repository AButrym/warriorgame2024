package khnu.mizhfac.interfaces;

public interface Warrior extends Cloneable,
        HasHealth, HasAttack, CanAcceptDamage, CanHealSelf {
    Warrior clone();
}
