import java.util.ArrayList;

public class Game {
    private final Board board = new Board();
    private ArrayList<Player> players = new ArrayList<Player>();

    public Board getBoard() { return board; }

    public void startGame(int numPlayers){

        for(int i = 1; i <= numPlayers; i++){
            System.out.print("Player " + i + " name: ");
            players.add(new Player(Input.read()));
        }

        turn(players.get(0));
    }

    //pass turn to next Player
    private void turn(Player currentPlayer){
        System.out.println(currentPlayer.getName() + "'s turn! You have $" + currentPlayer.getMoney() + ". You are on " + board.getSquareAt(currentPlayer.getPosition()).name);
        currentPlayer.move(roll());
        landedOn(currentPlayer);
        endTurn(currentPlayer);

        //TODO switch for user choice
    }

    private void endTurn(Player currentPlayer){
        int currentIndex = players.indexOf(currentPlayer);
        if(currentIndex + 1 == players.size()){
            turn(players.get(0));
        } else {
            turn(players.get(currentIndex + 1));
        }
    }

    //return sum of two dice rolls
    private int roll(){
        System.out.print("Press enter to roll");
        Input.read();

        int roll1;
        int roll2;

        roll1 = (int) (Math.random() * 6 + 1);
        roll2 = (int) (Math.random() * 6 + 1);

        System.out.println("Rolled a " + roll1 + " and " + roll2);
        return roll1 + roll2;
    }
    
    private void landedOn(Player currentPlayer){
        Square currentSquare = board.getSquareAt(currentPlayer.getPosition());

        System.out.println("Landed on " + currentSquare.getName());
        currentSquare.doAction(currentPlayer);
    }

}
