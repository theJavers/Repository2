public class Warrior extends Character implements Attacker {
    private int stamina;
    private int strength;

    //constructor
   public Warrior(String name) {
       super(name);
   }
    //Miki: ¿este constructor está sobrecargado por algún motivo o se puede elimintar el primero?
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



    //IMPLEMENTS INTERFACE


    public void attack(Character rival) {
        if (this.stamina >= 5){

            rival.receiveDamage(this.strength);
            setStamina(stamina - 5);
            System.out.println("Fire Ball!!");

        }else{

            rival.receiveDamage(2);
            setStamina(stamina + 1);
            System.out.println("Staff hit!");
        }
    }

}
