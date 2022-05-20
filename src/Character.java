abstract class Character {
    private int id;
    private String name;
    private int hp;
    private boolean isAlive;

    public Character(String name) {
        setId();
        setName(name);
        setHp();
        isAlive = true;
    }
    //////////////////SETTER/////////////
    public void setId(){
        int counter = 1;
        this.id = counter++;
    };

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(){}

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