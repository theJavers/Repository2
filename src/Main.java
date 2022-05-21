public class Main {

    public static void main(String[] args) {

        PartyFactory partyFactory = new PartyFactory();
        Party party = partyFactory.createRandomParty(5);
        System.out.println(party.getParty1());
        System.out.println(party.getParty2());

        System.out.println("PARTY 1 WAS CREATED => ");
        for(Character c: party.getParty1()) {
            System.out.println("party1: " + c.getName());
        }
        System.out.println("PARTY 2 WAS CREATED => ");
        for(Character c: party.getParty2()) {
            System.out.println("party2: " + c.getName());
        }
    }



}

