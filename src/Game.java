import java.util.ArrayList;

public class Game {
    private Input input = new Input();
    private final Board board = new Board();
    private Dice dice = new Dice();
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
        System.out.println("\n" + currentPlayer.getName() + "'s turn!\nPosition: " + board.getSquareAt(currentPlayer.getPosition()).getName() + "\nMoney: $" + currentPlayer.getMoney());
        currentPlayer.move(dice.roll(input));
        landedOn(currentPlayer);
        showOptions(currentPlayer);
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
        System.out.println("Additional Actions:");
        System.out.println("(1) List Properties\n(2) Buy Houses\n(3) End Turn");

        try {
            int choice = Integer.parseInt(input.read());

            switch(choice){
                case 1:
                    currentPlayer.listProperties();
                    showOptions(currentPlayer);
                case 2:
                    buyHouseOptions(currentPlayer);
                case 3:
                    endTurn(currentPlayer);
            }
        } catch (NumberFormatException e){
            System.out.println("Must enter a valid number");
        }
    }

    private void buyHouseOptions(Player currentPlayer){
        System.out.println("Select property to purchase house on: ");
        ColorProperty houseProperty = (ColorProperty) input.selectOptions(currentPlayer.listOwnColorGroup(board));
        houseProperty.addHouse();
    }

    private void landedOn(Player currentPlayer){
        Square currentSquare = board.getSquareAt(currentPlayer.getPosition());

        System.out.println("Landed on " + currentSquare.getName());
        currentSquare.doAction(currentPlayer);
    }
}
