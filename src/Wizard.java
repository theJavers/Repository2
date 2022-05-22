public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    //constructor
    public Wizard(String name, int hp) {
        super(name, hp);
    }

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
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
    public void attack(Character rival, Character character) {
        if (this.mana >= 5){

            rival.receiveDamage(this.intelligence, character, rival);
            setMana(mana - 5);
            System.out.println(getName() + " does FIREBALL (" + this.intelligence + ").\n" + rival.getName() + " HP: " + rival.getHp() + " points. \n" +
                    "---------");

        }else{

            rival.receiveDamage(2, character, rival);
            setMana(mana + 1);
            System.out.println(getName() + " does STAFF HIT (" + 2 + ").\n" + rival.getName() + " HP: " + rival.getHp() + " points. \n" +
                    "----------");
        }
    }

}
