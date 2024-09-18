package khnu.mizhfac;

import java.util.Iterator;

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
//        Iterator<Warrior> it1 = first.firstAliveWarriorsIterator();
//        Iterator<Warrior> it2 = second.firstAliveWarriorsIterator();
//        while (it1.hasNext() && it2.hasNext()) {
//            Warrior w1 = it1.next();
//            Warrior w2 = it2.next();
//            fight(w1, w2);
//        }
//        return it1.hasNext();

        while (first.isAlive() && second.isAlive()) {
            fight(first.getChampion(), second.getChampion());
        }
        return first.isAlive();

    }
}
