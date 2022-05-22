import java.util.List;
import java.util.ArrayList;

public class Party {

    public List<Character> characters = new ArrayList<Character>();

    public Party() {}

    public Party(List<Character> characters) {
        this.characters = characters;
    }

    public List<Character> getCharacters() {
        return this.characters;
    }
    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void removeCharacter(Character character) {

    }

}