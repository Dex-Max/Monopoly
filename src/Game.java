import java.util.ArrayList;
import java.util.Collections;

public class Game {
    private Input input = new Input();
    private final Board board = new Board();
    private Jail jail = new Jail();
    private Dice dice = new Dice(input);
    private ArrayList<Player> players = new ArrayList<Player>();

    public Board getBoard() { return board; }

    public void startGame(int numPlayers){

        for(int i = 1; i <= numPlayers; i++){
            System.out.print("Player " + i + " name: ");
            players.add(new Player(input.read()));
        }

        turn(players.get(0));
    }

    //pass turn to next Player
    private void turn(Player currentPlayer){
        System.out.println("\n" + currentPlayer.getName() + "'s turn!\nMoney: $" + currentPlayer.getMoney());

        if(currentPlayer.inJail){
            jail.jailTurn(currentPlayer);
        } else {
            System.out.println("Position: " + board.getCurrentSquare(currentPlayer));
            currentPlayer.move(dice.roll());

            System.out.println("Landed on " + board.getCurrentSquare(currentPlayer));
            board.getCurrentSquare(currentPlayer).doAction(currentPlayer);

            showOptions(currentPlayer);
        }
    }

    private void endTurn(Player currentPlayer){
        int currentIndex = players.indexOf(currentPlayer);
        if(currentIndex + 1 == players.size()){
            turn(players.get(0));
        } else {
            turn(players.get(currentIndex + 1));
        }
    }

    private void showOptions(Player currentPlayer){
        ArrayList<PlayerOption> options = new ArrayList<>();
        Collections.addAll(options,
                new ListPropertiesOption(currentPlayer),
                new BuyHouseOption(currentPlayer, input),
                new EndTurnOption()
                );

        PlayerOption selectedOption = (PlayerOption) input.selectOptions(options, "Additional Actions:");

        if(selectedOption instanceof EndTurnOption){
            endTurn(currentPlayer);
        } else {
            selectedOption.action();
            showOptions(currentPlayer);
        }
    }

    //TODO rid of and combine
    private void landedOn(Player currentPlayer){
        Square currentSquare = board.getSquareAt(currentPlayer.getPosition());

        System.out.println("Landed on " + currentSquare);
        currentSquare.doAction(currentPlayer);
    }
}
