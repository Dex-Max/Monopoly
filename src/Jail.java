import java.util.Arrays;
import java.util.List;

public class Jail{ //separate from Visiting Jail square on board
    private Game game;

    public void setGame(Game game){
        this.game = game;
    }

    public void sendToJail(Player jailedPlayer){
        jailedPlayer.inJail = true;
        System.out.println("You are now in Jail for the next 3 turns");
        game.endTurn(jailedPlayer);
    }

    public boolean jailTurn(Player currentPlayer, Dice dice, Board board){ //returns true if player escaped jail on turn
        currentPlayer.turnsInJail++;
        System.out.print("Turn " + currentPlayer.turnsInJail);

        if(currentPlayer.turnsInJail == 3){
            currentPlayer.inJail = false;

            int roll = dice.roll();
            if(!dice.isDouble()){
                currentPlayer.addMoney(-50);
            }

            currentPlayer.move(roll, board);
        }

        List<PlayerOption> jailOptions = Arrays.asList(
                new RollOptionJail(dice, currentPlayer, board),
                new PayBailOption(dice, currentPlayer, board)
        );

        PlayerOption selectedOption = (PlayerOption) Input.selectOptions(jailOptions, "Roll a double or pay $50 to escape");
        selectedOption.action();

        return currentPlayer.inJail;
    }
}
