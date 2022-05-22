public class Main {

    public static void main(String[] args) {
        PartyFactory partyFactory = new PartyFactory();
        Party party1 = partyFactory.createRandomParty(5);
        Party party2 = partyFactory.createRandomParty(5);


        Battle prueba = new Battle(party1, party2);
        //Character fighter1 = prueba.chooseCharacter(party1);
        //Character fighter2 = prueba.chooseCharacter(party2);
        prueba.duel();
    }



}
