public abstract class Character implements Attacker {
    private static int counter = 0;

    private final int id;
    private String name;
    private int hp;
    private boolean isAlive;

    public Character(String name, int hp) {
        counter++;
        this.id = counter; // para generar el id y que no se pueda cambiar
        setName(name);
        setHp(hp);
        isAlive = true;
    }
    //////////////////SETTER////////////

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {

        this.hp = hp;
    }

    public void setIsAlive(Character character) {
        isAlive = false;

    }

    //////////////////////////GETTER////////////
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {

        return this.hp;
    }

    public boolean getIsAlive() {

        return this.isAlive;
    }

    public void receiveDamage(int damage, Character character, Character rival) {
        if (this.hp > 0) {
            this.hp = this.hp - damage;
        } else {
            setIsAlive(character);
        }


    }
}