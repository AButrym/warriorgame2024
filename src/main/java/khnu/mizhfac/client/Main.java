package khnu.mizhfac.client;

import khnu.mizhfac.Army;
import khnu.mizhfac.Battle;
import khnu.mizhfac.WarriorType;
import khnu.mizhfac.interfaces.Warrior;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main1(String[] args) {
        Warrior lancer = WarriorType.LANCER.create();
        Warrior warrior = WarriorType.WARRIOR.create();
        Warrior knight = WarriorType.KNIGHT.create();
        Army army1 = new Army()
                .addOneUnit(lancer);
        Army army2 = new Army()
                .addOneUnit(warrior)
                .addOneUnit(knight);
        Battle.fight(army1, army2);
        System.out.println("==========");
        Warrior lancer2 = WarriorType.LANCER.create();
        Warrior defender1 = WarriorType.DEFENDER.create();
        Warrior defender2 = WarriorType.DEFENDER.create();
        Army army3 = new Army().addOneUnit(lancer2);
        Army army4 = new Army().addOneUnit(defender1).addOneUnit(defender2);
        Battle.fight(army3, army4);
    }

    public static void main(String... args) {
        Warrior lancer = WarriorType.LANCER.create();
        Warrior warrior = WarriorType.WARRIOR.create();
        Warrior healer = WarriorType.HEALER.create();
        Army army1 = new Army()
                .addOneUnit(lancer);
        Army army2 = new Army()
                .addOneUnit(warrior)
                .addOneUnit(healer);
        Battle.fight(army1, army2);
        System.out.println("==========");
        Army army3 = new Army()
                .addUnits(WarriorType.LANCER::create, 1)
                .addUnits(WarriorType.HEALER::create, 1);
        Army army4 = new Army()
                .addUnits(WarriorType.KNIGHT::create, 1)
                .addUnits(WarriorType.HEALER::create, 2);
        Battle.fight(army3, army4);
        System.out.println(army3);
        System.out.println(army4);
    }
}