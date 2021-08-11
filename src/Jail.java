import java.util.ArrayList;
import java.util.Collections;

public class Jail{ //separate from Visiting Jail square on board
    public Jail(){

    }

    public void sendToJail(Player jailedPlayer){
        jailedPlayer.inJail = true;
    }

    public void jailTurn(Player currentPlayer, Dice dice){
        currentPlayer.turnsInJail++;
        System.out.print("Turn " + currentPlayer.turnsInJail);

        ArrayList<PlayerOption> jailOptions = new ArrayList<>();
        Collections.addAll(jailOptions, new RollOption(dice), new PayBailOption(currentPlayer));
        PlayerOption selectedOption = (PlayerOption) Input.selectOptions(jailOptions, "Roll a double or pay $50 to escape");
    }
}
