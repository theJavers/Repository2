public class Wizard extends Character {
    private int mana;
    private int intelligence;

    //constructor
    public Wizard(String name) {
        super(name);
    }

    public Wizard(String name, int mana, int intelligence) {
        super(name);
        setMana(mana);
        setIntelligence(intelligence);
    }



    // getters and setters
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }


}
