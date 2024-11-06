package khnu.mizhfac.client;

import khnu.mizhfac.Battle;
import khnu.mizhfac.WarriorType;
import khnu.mizhfac.interfaces.Warrior;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Warrior vampire = WarriorType.VAMPIRE.create();
        Warrior defender = WarriorType.DEFENDER.create();
        Battle.fight(vampire, defender);
    }
}