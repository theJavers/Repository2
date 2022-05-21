import java.util.List;
import java.util.ArrayList;

public class PartyFactory {

    private List<String> names = new ArrayList<>();
    private List<String> usedNames = new ArrayList<>();

    public PartyFactory() {
        this.names = names;
        names.add("Miki");
        names.add("Alejandro");
        names.add("Carwi");
        names.add("Marina");
        names.add("Eneko");
    }

    private String getRandomName() {
        int randomIndex = (int) Math.floor(Math.random() * names.size());
        String name = names.get(randomIndex);
        if(usedNames.contains(name)) {
            name = name + " Jr";
        } //Miki: Queda pendiente el else para cuando ya no queden más nombres".
        usedNames.add(name);
        return name;
    }

    private Character getRandomCharacter() {
        String name = getRandomName();
        if (Math.random() > 0.5) {
            // new wizardFactory().getWizard(name)
            return new Wizard(name);
        }
        return new Warrior(name);

    }

    public Party createRandomParty(int n) {
        List<Character> randomCharacters = new ArrayList<Character>();
        for (int i = 0; i < n + 1; i++) {
            randomCharacters.add(getRandomCharacter());
        }
        return new Party(randomCharacters, randomCharacters);
    }
}
