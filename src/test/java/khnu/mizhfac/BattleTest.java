package khnu.mizhfac;

import khnu.mizhfac.interfaces.Warrior;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static khnu.mizhfac.WarriorFactory.createWarrior;
import static org.junit.jupiter.api.Assertions.*;

public class BattleTest {
    @Test
    @DisplayName("Smoke test for stage 2 Army Battles")
    void stage2() {
        // arrange  given
        var myArmy = new Army();
        myArmy.addUnits(() -> createWarrior("WARRIOR"), 3);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 3);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 20);
        army3.addUnits(Knight::new, 5);

        var army4 = new Army();
        army4.addUnits(Warrior::new, 30);

        assertTrue(Battle.fight(myArmy, enemyArmy));
        assertFalse(Battle.fight(army3, army4));
    }

    @Test
    @DisplayName("1. Battle")
    void battle1() {
        var army1 = new Army()
                .addUnits(Warrior::new, 1);
        var army2 = new Army()
                .addUnits(Warrior::new, 2);

        boolean result = Battle.fight(army1, army2);

        assertFalse(result);
    }

    @Test
    @DisplayName("2. Battle")
    void battle2() {
        var army1 = new Army()
                .addUnits(Warrior::new, 2);
        var army2 = new Army()
                .addUnits(Warrior::new, 3);

        boolean result = Battle.fight(army1, army2);

        assertFalse(result);
    }

    @Test
    @DisplayName("3. Battle")
    void battle3() {
        var army1 = new Army()
                .addUnits(Warrior::new, 5);
        var army2 = new Army()
                .addUnits(Warrior::new, 7);

        boolean result = Battle.fight(army1, army2);

        assertFalse(result);
    }

    @Test
    @DisplayName("4. Battle")
    void battle4() {
        var army1 = new Army()
                .addUnits(Warrior::new, 20);
        var army2 = new Army()
                .addUnits(Warrior::new, 21);

        boolean result = Battle.fight(army1, army2);

        assertTrue(result);
    }

    @Test
    @DisplayName("5. Battle")
    void battle5() {
        var army1 = new Army()
                .addUnits(Warrior::new, 10);
        var army2 = new Army()
                .addUnits(Warrior::new, 11);

        boolean result = Battle.fight(army1, army2);

        assertTrue(result);
    }

    @Test
    @DisplayName("6. Battle")
    void battle6() {
        var army1 = new Army()
                .addUnits(Warrior::new, 11);
        var army2 = new Army()
                .addUnits(Warrior::new, 7);

        boolean result = Battle.fight(army1, army2);

        assertTrue(result);
    }

    @Test
    @DisplayName("Test for cloning")
    void battleClone() {
        var warrior1 = new Warrior();
        var warrior2 = new Warrior();
        Battle.fight(warrior1, warrior2);
        assertTrue(warrior1.isAlive());

        var army1 = new Army()
                .addUnits(Warrior::new, 1);
        var army2 = new Army()
                .addUnits(warrior1::clone, 100);

        boolean result = Battle.fight(army1, army2);

        assertTrue(result);
    }

    @Test
    @DisplayName("Simple test for cloning")
    void battleClone1() {
        var warrior1 = new Warrior();
        var warrior2 = new Warrior();
        Battle.fight(warrior1, warrior2);
        assertTrue(warrior1.isAlive());
        var warrior3 = warrior1.clone();
        assertEquals(warrior1.getHealth(), warrior3.getHealth());
    }
}
