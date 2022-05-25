public class WizardFactory {

    public Wizard getWizard(String name) {
        return new Wizard(name, getRandomHp(), getRandomMana(), getRandomIntelligence());
    }

    private int getRandomHp() {
        return (int) Math.floor(Math.random() * 51 + 50);
    }

    private int getRandomMana() {
        return (int) Math.floor(Math.random() * 41 + 10);
    }

    private int getRandomIntelligence() {
        return (int) Math.floor(Math.random() * 51 + 1);
    }
}
