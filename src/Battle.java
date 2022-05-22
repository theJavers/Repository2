import java.util.Scanner;

public class Battle {

    private Scanner input = new Scanner(System.in);

    private Party party1 = new PartyFactory().createRandomParty(5);
    private Party party2 = new PartyFactory().createRandomParty(5);


    public Battle(Party party1, Party party2) {
        setParty1(party1);
        setParty2(party2);
    }

    public void setParty1(Party party1) {
        this.party1 = party1;
        System.out.println("Party 1 was created: ");
        System.out.println("========== \n PARTY 1 ============ \n");
        for (Character c : party1.getCharacters()) {
            stats(c);
        }
    }

    public void setParty2(Party party2) {
        this.party2 = party2;
        System.out.println("Party 2 was created: ");
        System.out.println("========== \n PARTY 2 ============ \n");
        for (Character c : party2.getCharacters()) {
            stats(c);
        }
    }

    public Character chooseCharacter(Party party) {
        System.out.println("Choose a character: ");
        String chosenCharacter = input.nextLine();
        Character fighter = null;
        for (int i = 0; i < party.characters.size(); i++) {
            Character f = party.characters.get(i);
            if (f.getName().equals(chosenCharacter)) {
                System.out.println(f.getName() + " was selected to fight");
                fighter = f;
            }
        }
        if (fighter == null) {
            System.err.println("Fighter not found! Try again, please: ");
            fighter = chooseCharacter(party);
        }
        stats(fighter);
        return fighter;

    }

    public void stats(Character character) {
        String name = character.getName();
        int hp = character.getHp();
        if (character.getClass() == Warrior.class) {
            Warrior warrior = (Warrior) character;
            int stamina = warrior.getStamina();
            int strength = warrior.getStrength();

            System.out.println(" ========== \nWarrior " + name + ": \n" + "HP: " +
                    hp + "\n" + "Stamina: "
                    + stamina + "\n" + "Strength: " +
                    strength + "\n ============== \n");
            ;
        } else {
            Wizard wizard = (Wizard) character;
            int mana = wizard.getMana();
            int intelligence = wizard.getIntelligence();
            System.out.println(" ============= \nWizard " + name + ": \n" + "HP: " +
                    hp + "\n" + "Mana: "
                    + mana + "\n" + "Intelligence: " +
                    intelligence + "\n ============== \n");
        }


    }
    /*public void bothAttacks() {
        Character fighter1 = chooseCharacter(party1);
        Character fighter2 = chooseCharacter(party2);


    }*/

    public void duel() {
        Character fighter1 = chooseCharacter(party1);
        Character fighter2 = chooseCharacter(party2);

        while (fighter1.getIsAlive() && fighter2.getIsAlive()) {
                fighter1.attack(fighter2, fighter1);
                fighter2.attack(fighter1, fighter2);

            }

        if (fighter1.getIsAlive()) {
            System.out.println(fighter1.getName() + " won the fight!");
        } else {
            System.out.println(fighter2.getName() + " won the fight!");
        }



    }


}
