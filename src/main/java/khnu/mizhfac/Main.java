package khnu.mizhfac;

public class Main {
    public static void main(String[] args) {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();

        assert Battle.fight(chuck, bruce) == true;
        assert Battle.fight(dave, carl) == false;
        assert chuck.isAlive() == true;
        assert bruce.isAlive() == false;
        assert carl.isAlive() == true;
        assert dave.isAlive() == false;
    }
}