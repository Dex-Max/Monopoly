import java.util.Scanner;

public class Game {
    Board board = new Board();
    Player[] players;


    public Game(int numPlayers){
        players = new Player[numPlayers];
    }

    public Board getBoard() { return board; }

    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        for(int i = 1; i <= players.length; i++){
            System.out.println("Player " + i + " name: ");
            players[i - 1] = new Player(scanner.next());
        }

        turn(players[0]);
    }

    //pass turn to next Player
    private void turn(Player currentPlayer){
        System.out.println(currentPlayer.getName() + "'s turn! You are on " + board.getSquareAt(currentPlayer.getPosition()).name);
        currentPlayer.move(roll());             //moves player
        landedOn(currentPlayer); //does action of landed on square

        //TODO switch for user choice
        //case user wants to buy house
    }

    //return sum of two dice rolls
    private int roll(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to roll");
        scanner.next();

        int roll1;
        int roll2;

        roll1 = (int) (Math.random() * 6 + 1);
        roll2 = (int) (Math.random() * 6 + 1);

        System.out.println("You rolled a " + roll1 + " and " + roll2);
        return roll1 + roll2;
    }
    
    private void landedOn(Player currentPlayer){
        Square currentSquare = board.getSquareAt(currentPlayer.getPosition());

        System.out.println(currentPlayer.getName() + " landed on " + currentSquare.getName());
        currentSquare.doAction(currentPlayer);
    }

}
