package khnu.mizhfac;

import khnu.mizhfac.interfaces.Warrior;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class Army {
    private final List<Warrior> warriors = new ArrayList<>();

    public Army addUnits(
            Supplier<Warrior> supplier,
            int howMany
    ) {
        for (int i = 0; i < howMany; i++) {
            addOneUnit(supplier.get());
        }
        return this;
    }

    private void addOneUnit(Warrior warrior) {
        warriors.add(warrior);
    }

    public Iterator<Warrior> firstAliveWarriorsIterator() {
        return new AliveWarriorIterator();
    }

    public boolean isAlive() {
        return warriors.stream().anyMatch(Warrior::isAlive);
    }

    public Warrior getChampion() {
        return warriors.stream().filter(Warrior::isAlive).findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    private class AliveWarriorIterator implements Iterator<Warrior> {
        int ix = 0;

        @Override
        public boolean hasNext() {
            while (ix < warriors.size() &&
                   !warriors.get(ix).isAlive()) {
                ix++;
            }
            return ix < warriors.size();
        }

        @Override
        public Warrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return warriors.get(ix);
        }
    }
}
