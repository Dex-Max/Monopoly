public class Game {
    Square[] board = new Square[40];
    Player[] players;


    public Game(int numPlayers){
        players = new Player[numPlayers];
    }

    //pass turn to next Player
    private void turn(Player currentPlayer){

    }

    //return sum of two dice rolls
    private int roll(){
        int roll1;
        int roll2;

        roll1 = (int) Math.random() * 6 + 1;
        roll2 = (int) Math.random() * 6 + 1;
        return roll1 + roll2;
    }
}