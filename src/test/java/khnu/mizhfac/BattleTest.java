package khnu.mizhfac;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    @Test
    @DisplayName("Smoke test for stage 1")
    void fight() {
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
}