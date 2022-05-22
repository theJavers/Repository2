import java.util.ArrayList;
import java.util.List;

public class GraveYard {

    private List<Character> deads = new ArrayList<>();

    public GraveYard(List<Character> deads) {
        this.deads = deads;
    }

    private void addDead(Character dead) {
        deads.add(dead);
        System.out.println("One character went to the Grave Yard");
    }

    public List<Character> getDeads() {
        return deads;
    }


}
