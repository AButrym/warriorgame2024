package khnu.mizhfac;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FightTest {

    @Test
    @DisplayName("Smoke test for stage 1")
    void stage1() {
        // arrange  given
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
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
        Warrior warrior1 = new Warrior();
        Warrior warrior2 = new Knight();

        int warriorAttack = warrior1.getAttack();
        int knightAttack = warrior2.getAttack();

        assertEquals(Warrior.attack, warriorAttack);
        assertEquals(Knight.attack, knightAttack);
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
        var carl = new Warrior();
        var jim = new Knight();

        var answer = Battle.fight(carl, jim);

        assertFalse(answer);
    }
    @Test
    @DisplayName("2. Fight")
    void fight2() {
        var ramon = new Knight();
        var slevin = new Warrior();

        var answer = Battle.fight(ramon, slevin);

        assertTrue(answer);
    }
    @Test
    @DisplayName("3. Fight")
    void fight3() {
        var bob = new Warrior();
        var mars = new Warrior();

        Battle.fight(bob, mars);

        assertTrue(bob.isAlive());
    }

    @Test
    @DisplayName("4. Fight")
    void fight4() {
        var zeus = new Knight();
        var godkiller = new Warrior();

        Battle.fight(zeus, godkiller);

        assertTrue(zeus.isAlive());
    }

    @Test
    @DisplayName("5. Fight")
    void fight5() {
        var husband = new Warrior();
        var wife = new Warrior();

        Battle.fight(husband, wife);

        assertFalse(wife.isAlive());
    }

    @Test
    @DisplayName("6. Fight")
    void fight6() {
        var dragon = new Warrior();
        var knight = new Knight();

        Battle.fight(dragon, knight);

        assertTrue(knight.isAlive());
    }

    @Test
    @DisplayName("7. Fight")
    void fight7() {
        var unit1 = new Warrior();
        var unit2 = new Knight();
        var unit3 = new Warrior();

        Battle.fight(unit1, unit2);
        var answer = Battle.fight(unit2, unit3);

        assertFalse(answer);
    }

}