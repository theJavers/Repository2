public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    //constructor
    public Wizard(String name) {
        super(name);
    }
    //Miki: ¿este constructor está sobrecargado por algún motivo o se puede elimintar el primero?
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



    //IMPLEMENTS INTERFACE


    public void attack(Character rival) {
        if (this.mana >= 5){

            rival.receiveDamage(this.intelligence);
            setMana(mana - 5);
            System.out.println("Fire Ball!!");

        }else{

            rival.receiveDamage(2);
            setMana(mana + 1);
            System.out.println("Staff hit!");
        }
    }
}
