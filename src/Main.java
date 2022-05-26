import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    String p1;
    String path1;
    String p2;
    String path2;


    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.runMenuAndHeader();

    }

    //////// Printea el menu
    public void runMenuAndHeader() throws IOException {
        printHeader();
        printMenu();
        int choice = getInput();
        performAction(choice);

    }
    private void printHeader(){
        System.out.println("*--------------------------------*");
        System.out.println("|         Welcome to              |");
        System.out.println("|        Java Battles             |");
        System.out.println("|       ___                       |");
        System.out.println("|      /___\\                     |");
        System.out.println("|     (|0 0|)                     |");
        System.out.println("|   __/{\\U/}\\_ ___/vvv          |");
        System.out.println("|  / \\  {~}   / _|_P|            |");
        System.out.println("|  | /\\  ~   /_/   ||            |");
        System.out.println("|  |_| (____)      ||             |");
        System.out.println("|  \\_]/______\\  /\\_||_/\\      |");
        System.out.println("|     _\\_||_/_ |] _||_ [|        |");
        System.out.println("|    (_,_||_,_) \\/ [] \\/        |");
        System.out.println("*--------------------------------*");
        System.out.println("Choose how to create your party: \n");

    }
    private void printMenu(){
        System.out.println("1) Create random party");
        System.out.println("2) Import from CSV file");
        System.out.println("0) EXIT");
    }

    ////// Pilla el input de el player
    private int getInput(){
        Scanner kb = new Scanner(System.in);
        int choice = -1;
        while(choice < 0 || choice > 2){
            try{
                choice = Integer.parseInt(kb.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Invalid selection, please try again -_- \n");
                printMenu();

            }
        }
        return choice;
    }


    //////// Switch en función de el input
    private void performAction(int choice) throws IOException {
        switch (choice){
            case 0:
                System.out.println("Thanks for playing :)");
                break;
            case 1:
                p1 = "random";
                System.out.println("How do you want to create party 2? \n");
                printMenu();
                int choice2random = getInput();
                performAction2(choice2random);
                break;
            case 2:
                p1 = "CSV";
                path1 = fileChooser();
                System.out.println("How do you want to create party 2? \n");
                printMenu();
                int choice2csv = getInput();
                performAction2(choice2csv);
                break;
            default:
                System.out.println("An error has occoured.");
        }
    }

    private void performAction2(int choice) throws IOException {
        switch (choice){
            case 0:
                System.out.println("Thanks for playing :)");
                break;
            case 1:
                p2 = "random";
                startDuel();
                break;
            case 2:
                p2 = "CSV";
                path2 = fileChooser();
                startDuel();
                break;
            default:
                System.out.println("An error has occoured.");
        }
    }


    ///// Abre el explorador de archivos
    private String fileChooser (){
        JButton open = new JButton();
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new java.io.File("."));
        fc.setDialogTitle("Choose a CSV file");
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if(fc.showOpenDialog(open) ==JFileChooser.APPROVE_OPTION){
            //
        }
        return fc.getSelectedFile().getAbsolutePath();

    }


    public void startDuel() throws FileNotFoundException {

        Party party1 = null;
        Party party2 = null;
        while(party1 == null && party2 == null){
            if(p1 == "random"){
                System.out.println("How many fighters in party 1? (max 10)");
                Scanner kb = new Scanner(System.in);
                int fighters = -1;
                while(fighters < 1 || fighters > 10)
                    try{
                        fighters = Integer.parseInt(kb.nextLine());
                    }
                    catch (NumberFormatException e){
                        System.out.println("Parties must be smaller than 10");
                    }

                PartyFactory partyFactory = new PartyFactory();
                party1 = partyFactory.createRandomParty(fighters);


            }

            if(p2 == "random"){
                System.out.println("How many fighters in party 2? (max 10)");
                Scanner kb = new Scanner(System.in);
                int fighters = -1;
                while(fighters < 1 || fighters > 10)
                    try{
                        fighters = Integer.parseInt(kb.nextLine());
                    }
                    catch (NumberFormatException e){
                        System.out.println("Parties must be smaller than 10");
                    }

                PartyFactory partyFactory = new PartyFactory();
                party2 = partyFactory.createRandomParty(fighters);

            }
            if(p1 == "CSV"){
                PartyFactoryCSV partyFactoryCSV2 = new PartyFactoryCSV(path1);
                party1 = partyFactoryCSV2.createRandomParty2();
            }
            if(p2 == "CSV"){
                PartyFactoryCSV partyFactoryCSV2 = new PartyFactoryCSV(path2);
                party2 = partyFactoryCSV2.createRandomParty2();
            }
        }



        Battle battle = new Battle(party1, party2);
        battle.duel();


    }

}

