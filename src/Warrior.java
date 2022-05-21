public class Warrior extends Character {
    private int stamina;
    private int strength;

    //constructor
   public Warrior(String name) {
       super(name);
   }

    public Warrior(String name, int stamina, int strength) {
        super(name);
        setStamina(stamina);
        setStrength(strength);
    }

    // getters and setters

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
