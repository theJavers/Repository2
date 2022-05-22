public class Main {

    public static void main(String[] args) {



        PartyFactory partyFactory = new PartyFactory();
        Party party1 = partyFactory.createRandomParty(1);
        Party party2 = partyFactory.createRandomParty(1);


        Battle battle = new Battle(party1, party2);


                battle.duel();

            }


    }

