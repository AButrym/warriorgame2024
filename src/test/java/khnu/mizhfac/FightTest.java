package khnu.mizhfac;

import khnu.mizhfac.interfaces.Warrior;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static khnu.mizhfac.WarriorFactory.createWarrior;
import static khnu.mizhfac.WarriorType.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class FightTest {

    @Test
    @DisplayName("Smoke test for stage 1 Warrior")
    void stage1() {
        // arrange  given
        var chuck = createWarrior(WARRIOR);
        var bruce = createWarrior(WARRIOR);
        var carl = new Knight();
        var dave = createWarrior(WARRIOR);
        // act      when
        var resFight1 = Battle.fight(chuck, bruce);
        var resFight2 = Battle.fight(dave, carl);
        // assert   then
        assertAll(
                () -> assertTrue(resFight1),
                () -> assertFalse(resFight2),
                () -> assertTrue(chuck.isAlive()),
                () -> assertFalse(bruce.isAlive()),
                () -> assertTrue(carl.isAlive()),
                () -> assertFalse(dave.isAlive())
        );
    }

    @Test
    void testPolymorphicGetAttack() {
        Warrior warrior1 = createWarrior(WARRIOR);
        Warrior warrior2 = new Knight();

        int warriorAttack = warrior1.getAttack();
        int knightAttack = warrior2.getAttack();

        assertEquals(warrior1.ATTACK, warriorAttack);
        assertEquals(Knight.ATTACK, knightAttack);
    }

    /*
        * "1. Fight": [
            prepare_test(middle_code='''carl = Warrior() jim = Knight()''',
                         test="fight(carl, jim)",
                         answer=False)
                    ],
    */
    @Test
    @DisplayName("1. Fight")
    void fight1() {
        var carl = createWarrior(WARRIOR);
        var jim = new Knight();

        var answer = Battle.fight(carl, jim);

        assertFalse(answer);
    }
    @Test
    @DisplayName("2. Fight")
    void fight2() {
        var ramon = new Knight();
        var slevin = createWarrior(WARRIOR);

        var answer = Battle.fight(ramon, slevin);

        assertTrue(answer);
    }
    @Test
    @DisplayName("3. Fight")
    void fight3() {
        var bob = createWarrior(WARRIOR);
        var mars = createWarrior(WARRIOR);

        Battle.fight(bob, mars);

        assertTrue(bob.isAlive());
    }

    @Test
    @DisplayName("4. Fight")
    void fight4() {
        var zeus = new Knight();
        var godkiller = createWarrior(WARRIOR);

        Battle.fight(zeus, godkiller);

        assertTrue(zeus.isAlive());
    }

    @Test
    @DisplayName("5. Fight")
    void fight5() {
        var husband = createWarrior(WARRIOR);
        var wife = createWarrior(WARRIOR);

        Battle.fight(husband, wife);

        assertFalse(wife.isAlive());
    }

    @Test
    @DisplayName("6. Fight")
    void fight6() {
        var dragon = createWarrior(WARRIOR);
        var knight = new Knight();

        Battle.fight(dragon, knight);

        assertTrue(knight.isAlive());
    }

    @Test
    @DisplayName("7. Fight")
    void fight7() {
        var unit1 = createWarrior(WARRIOR);
        var unit2 = new Knight();
        var unit3 = createWarrior(WARRIOR);

        Battle.fight(unit1, unit2);
        var answer = Battle.fight(unit2, unit3);

        assertFalse(answer);
    }

    @Test
    @DisplayName("8. Fight")
    void fight8() {
        var unit1 = new Defender();
        var unit2 = new Rookie();

        Battle.fight(unit1, unit2);
        var answer = unit1.getHealth();

        assertEquals(Defender.INITIAL_HEALTH, answer);
    }

    @Test
    @DisplayName("9. Fight")
    void fight9() {
        var unit1 = new Defender();
        var unit2 = new Rookie();
        var unit3 = createWarrior(WARRIOR);

        Battle.fight(unit1, unit2);
        var answer = Battle.fight(unit1, unit3);

        assertTrue(answer);
    }

    static class Rookie extends Warrior {
        public int getAttack() {
            return 1;
        }
    }

    @Test
    @DisplayName("Warrior looses to Defender")
    void testWarriorVsDefender() {
        var warrior = createWarrior(WARRIOR);
        var defender = new Defender();

        var res = Battle.fight(warrior, defender);

        assertAll(
                () -> assertFalse(res),
                () -> assertEquals(-1, warrior.getHealth()),
                () -> assertEquals(9, defender.getHealth())
        );
    }

    @Test
    @DisplayName("Defender wins Vampire")
    void testDefenderVsVampire() {
        var defender = new Defender();
        var vampire = new Vampire();

        var res = Battle.fight(defender, vampire);

        assertAll(
                () -> assertTrue(res),
                () -> assertEquals(-1, vampire.getHealth()),
                () -> assertEquals(22, defender.getHealth())
        );
    }

    @Test
    @DisplayName("Vampire vs Rookie remains healthy")
    void testVampireVsRookieRemainHealthy() {
        var vampire = new Vampire();
        var rookie = new Rookie();

        var res = Battle.fight(rookie, vampire);

        assertAll(
                () -> assertFalse(res),
                () -> assertThat(vampire.getHealth())
                        .as(() -> "Vampire should not heal himself above original health")
                        .isEqualTo(Vampire.INITIAL_HEALTH)
        );
    }
}