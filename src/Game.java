import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private final Board board = new Board();
    private ArrayList<Player> players = new ArrayList<Player>();

    public Board getBoard() { return board; }

    public void startGame(int numPlayers){
        Scanner scanner = new Scanner(System.in);

        for(int i = 1; i <= numPlayers; i++){
            System.out.print("Player " + i + " name: ");
            players.add(new Player(scanner.next()));
        }

        turn(players.get(0));
        scanner.close();
    }

    //pass turn to next Player
    private void turn(Player currentPlayer){
        System.out.println(currentPlayer.getName() + "'s turn! You are on " + board.getSquareAt(currentPlayer.getPosition()).name);
        currentPlayer.move(roll());             //moves player
        landedOn(currentPlayer); //does action of landed on square


        //TODO switch for user choice
        //case user wants to buy house
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to roll");
        scanner.nextLine();

        int roll1;
        int roll2;

        roll1 = (int) (Math.random() * 6 + 1);
        roll2 = (int) (Math.random() * 6 + 1);

        System.out.println("You rolled a " + roll1 + " and " + roll2);
        scanner.close();
        return roll1 + roll2;
    }
    
    private void landedOn(Player currentPlayer){
        Square currentSquare = board.getSquareAt(currentPlayer.getPosition());

        System.out.println(currentPlayer.getName() + " landed on " + currentSquare.getName());
        currentSquare.doAction(currentPlayer);
    }

}
