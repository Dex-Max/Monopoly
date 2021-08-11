public class Jail{ //separate from Visiting Jail square on board
    public Jail(){

    }

    public void sendToJail(Player jailedPlayer){
        jailedPlayer.inJail = true;
    }

    public void jailTurn(Player currentPlayer){
        currentPlayer.turnsInJail++;
        System.out.println("Turn " + currentPlayer.turnsInJail + " in jail. Roll a double or pay $50 to escape");
        System.out.println("1. Roll\n2. Pay $50");

    }
}
