import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PartyFactoryCSV {

    public List<String> names1 = new ArrayList<>();
    // private List<String> usedNames = new ArrayList<>();

    public PartyFactoryCSV() throws FileNotFoundException {
        File file = new File("Prueba.csv");
        Scanner reader = new Scanner(file);


        while (reader.hasNextLine()) {
            names1.add(reader.nextLine());
        }
    }

    int i = 0;

    private Character getRandomCharacter1() {

        String name = names1.get(i);
        if (Math.random() > 0.5) {
            i++;
            Wizard wizard = new WizardFactory().getWizard(name);
            return wizard;
        }
        Warrior warrior = new WarriorFactory().getWarrior(name);
        i++;
        return warrior;
    }

    public Party createRandomParty1() {
        List<Character> randomCharacters = new ArrayList<Character>();
        for (int i = 0; i < names1.size(); i++) {
            randomCharacters.add(getRandomCharacter1());
        }
        return new Party(randomCharacters);
    }

    int j = 0;

    private Character getRandomCharacter2() {
        String name = names1.get(j);
        if (Math.random() > 0.5) {
            j++;
            Wizard wizard = new WizardFactory().getWizard(name);
            return wizard;
        }
        Warrior warrior = new WarriorFactory().getWarrior(name);
        j++;
        return warrior;
    }

    public Party createRandomParty2() {
        List<Character> randomCharacters = new ArrayList<Character>();
        for (int j = 0; j < names1.size(); j++) {
            randomCharacters.add(getRandomCharacter2());
        }
        return new Party(randomCharacters);
    }
}
