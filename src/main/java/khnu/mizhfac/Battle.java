package khnu.mizhfac;

public class Battle {
    public static boolean fight(
            Warrior first,
            Warrior second
    ) {
        while (first.isAlive() && second.isAlive()) {
            first.hit(second);
            if (second.isAlive()) {
                second.hit(first);
            }
        }
        return first.isAlive();
    }

    public static boolean fight(
            Army first,
            Army second
    ) {
        return false;
    }
}
