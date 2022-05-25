import java.sql.SQLOutput;
import java.util.Scanner;

public class Battle {

    private Scanner input = new Scanner(System.in);

    private Party party1 = new PartyFactory().createRandomParty(5);
    private Party party2 = new PartyFactory().createRandomParty(5);

    private Graveyard graveyard = new Graveyard();


    public Battle(Party party1, Party party2) {
        setParty1(party1);
        setParty2(party2);
    }

    public void setParty1(Party party1) {
        this.party1 = party1;
        System.out.println("-------------------------- ");
        System.out.println("Party 1 was created: ");
        System.out.println("-------------------------- ");
    }

    public void setParty2(Party party2) {
        this.party2 = party2;
        System.out.println("-------------------------- ");
        System.out.println("Party 2 was created: ");
        System.out.println("-------------------------- ");
    }

    public Character chooseCharacter(Party party) {

        System.out.println("\nChoose a character :");
        String chosenCharacter = input.nextLine();

        Character fighter = null;

        for (int i = 0; i < party.characters.size(); i++) {

            Character f = party.characters.get(i);

            if (f.getName().equals(chosenCharacter)) {
                System.out.println(f.getName() + " was selected to fight ");
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

            System.out.println("--> Warrior " + name + ": " + " HP: " +
                    hp  + " | Stamina: " + stamina + " | Strength: " +
                    strength +  " | ");

        } else {

            Wizard wizard = (Wizard) character;
            int mana = wizard.getMana();
            int intelligence = wizard.getIntelligence();
            System.out.println("--> Wizard " + name + ": " + " HP: " +
                    hp + " | Mana: "
                    + mana + "| Intelligence: " +
                    intelligence + " | ");
        }


    }

    public void round(Character fighter1, Character fighter2) {


        System.out.printf(
                "[ " + fighter1.getName() + " does: *" + fighter1.attack(fighter2, fighter1)
                        + "* || " +
                        fighter2.getName() + " does: *" + fighter2.attack(fighter1, fighter2) + "* ] \n"
        );

        if (fighter1.getHp() > 0 && fighter2.getHp() > 0) {
            stats(fighter1);
            stats(fighter2);
        } else {
            if (fighter1.getHp() <= 0) {
                fighter1.setHp(0);
                stats(fighter1);
                stats(fighter2);
                System.out.printf("\n -------------------- KO!! \n"
                        + fighter2.getName() + " WON THE BATTLE!!! :D \n"
                        + fighter1.getName() + " died and went to the Graveyard  :( ");

                party1.removeCharacter(fighter1);
                graveyard.addDead(fighter1);
                graveyard.printGraveyard();




            } else if (fighter2.getHp() <= 0){
                fighter2.setHp(0);
                stats(fighter1);
                stats(fighter2);
                System.out.printf("\n !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n :D  "
                        + fighter1.getName() + "  WON THE BATTLE!!!  \n"
                        + " :(  " + fighter2.getName() + " died and went to the Graveyard ");

                party2.removeCharacter(fighter2);
                graveyard.addDead(fighter2);
                graveyard.printGraveyard();
            }

        }
    }

    public void duel() {

        while (party1.characters.size() > 0 && party2.characters.size() > 0) {

            System.out.println("-------------------------- ");
            System.out.println("\nParty 1: ");
            for (Character c : party1.getCharacters()) {
                stats(c);
            }
            System.out.println("-------------------------- ");

            System.out.println("\nParty 2: ");
            for (Character c : party2.getCharacters()) {
                stats(c);
            }
            System.out.println("-------------------------- ");


            Character fighter1 = chooseCharacter(party1);
            Character fighter2 = chooseCharacter(party2);

            System.out.println("Press Enter to Start the Fight!: ");
            input.nextLine();

            System.out.println(" FIGHT!!!!");

            int round = 0;

            while (fighter1.getHp() > 0 && fighter2.getHp() > 0) {
                round++;
                System.out.printf("\n round: " + round + "\n");
                round(fighter1, fighter2);
            }

            endGame();

        }
    }

    public void endGame(){
        if (party1.characters.size() == 0){
            System.out.println("\nEND-------\n Party 2 Won the battle, party 1 lose");

        } else if (party2.characters.size() == 0){
            System.out.println("\nEND------- \n Party 1 Won the battle, party 2 lose");
        }
    }

}
