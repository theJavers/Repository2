public class WarriorFactory {

    public Warrior getWarrior(String name) {
        return new Warrior(name, getRandomHp(), getRandomStamina(), getRandomStrength());
    }

    private int getRandomHp() {
        return (int) Math.floor(Math.random() * 101 + 100);
    }

    private int getRandomStamina() {
        return (int) Math.floor(Math.random() * 41 + 10);
    }

    private int getRandomStrength() {
        return (int) Math.floor(Math.random() * 10 + 1);
    }
}
