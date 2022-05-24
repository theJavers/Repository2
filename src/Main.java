import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Choose party mode type (random or CSV)");
        Scanner input = new Scanner(System.in);

        String partyMode = input.nextLine();

        if (partyMode.equals("CSV")) {
           PartyFactoryCSV partyFactoryCSV = new PartyFactoryCSV();
            Party party1 = partyFactoryCSV.createRandomParty1();
            Party party2 = partyFactoryCSV.createRandomParty2();

            Battle battle = new Battle(party1, party2);


            battle.duel();
        } else{

            PartyFactory partyFactory = new PartyFactory();
            Party party1 = partyFactory.createRandomParty(1);
            Party party2 = partyFactory.createRandomParty(1);


            Battle battle = new Battle(party1, party2);


            battle.duel();
        }

    }


}

