public abstract class Character {
    private static int counter = 0;
    private final int id;
    private String name;
    private int hp;
    private boolean isAlive;

    public Character(String name) {
        this.counter++;
        this.id = this.counter; // para generar el id y que no se pueda cambiar.
        setName(name);
        this.hp = this.hp; //Miki: aquí debemos pensar si le pasamos el parámetro de ph desde fuera o lo seteamos aquí mismo en un valor siempre igual.
        isAlive = true;
    }
    //////////////////SETTER////////////

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp ){ this.hp = hp; }

    public void setIsAlive(){
        if(getHp() <= 0 ){
            isAlive = false;
        }
    }

    //////////////////////////GETTER////////////
    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getHp(){
        return this.hp;
    }

    public boolean getIsAlive(){
        return this.isAlive;
    }
}