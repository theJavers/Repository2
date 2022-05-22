public class Warrior extends Character implements Attacker {
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
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

    public void attack(Character rival) {
        if (this.stamina >= 5){

            rival.receiveDamage(this.strength);
            setStamina(stamina - 5);
            System.out.println("Heavy attack!!");

        }else{

            rival.receiveDamage(2);
            setStamina(stamina + 1);
            System.out.println("Weak attack!");
        }
    }
}
