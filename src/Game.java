public class Game {
    Board board = new Board();
    Player[] players;


    public Game(int numPlayers){
        players = new Player[numPlayers];
    }

    //pass turn to next Player
    private void turn(Player currentPlayer){
        currentPlayer.move(roll());             //moves player
        board.getSquareAt(currentPlayer.getPosition()).landedOn(); //does action of landed on square
         /*
         * currentPlayer.landedOn(board.getSquare(currentPlayer.getPosition()));
         */
    }

    //return sum of two dice rolls
    private int roll(){
        int roll1;
        int roll2;

        roll1 = (int) Math.random() * 6 + 1;
        roll2 = (int) Math.random() * 6 + 1;

        System.out.println("You rolled a " + (roll1 + roll2));
        return roll1 + roll2;
    }

}
