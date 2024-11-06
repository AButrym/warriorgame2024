package khnu.mizhfac;

import khnu.mizhfac.interfaces.Warrior;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
        var res = first.isAlive();
        if (log.isDebugEnabled()) {
            if (res) {
                log.debug("{} is dead", second);
                log.debug("{} is the winner", first);

            } else {
                log.debug("{} is dead", first);
                log.debug("{} is the winner", second);
            }
        }
        return res;
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
