public class Main {

    public static void main(String[] args) {

        PartyFactory partyFactory = new PartyFactory();
        Party party = partyFactory.createRandomParty(20);
        System.out.println(party.getCharacters());


        for(Character c: party.getCharacters()) {
            System.out.println("party1: " + c.getName());
        }

    }



}

