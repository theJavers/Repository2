import java.util.List;
import java.util.ArrayList;

public class Party {

    public List<Character> party1 = new ArrayList<Character>();
    public List<Character> party2 = new ArrayList<Character>();

    public Party(List<Character> party1, List<Character> party2) {
        setParty1(party1);
        setParty2(party2);
    }

    public List<Character> getParty1() {
        return party1;
    }

    public void setParty1(List<Character> party1) {
        this.party1 = party1;
    }

    public List<Character> getParty2() {
        return party2;
    }

    public void setParty2(List<Character> party2) {
        this.party2 = party2;
    }
}
