import java.util.ArrayList;
import java.util.List;

public class GraveYard {

    private List<Character> deads = new ArrayList<>();

    public GraveYard(){}

    public GraveYard(List<Character> deads) {
        this.deads = deads;
    }

    public void addDead(Character dead) {
        deads.add(dead);
        System.out.println("One character went to the Grave Yard.");
    }

    public List<Character> getDeads() {
        return deads;
    }


    public void printGraveyard(){
        System.out.println("GRAVEYARD: ");
        for(Character c : deads){
            System.out.println(c);
        }
    }


}
