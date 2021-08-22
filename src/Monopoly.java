import java.util.ArrayList;

public class Monopoly {
    public static void main(String[] args){
        Dice dice = new Dice();
        Jail jail = new Jail();
        Board board = new Board(jail, dice);

        Game game = new Game(jail, dice, board, createPlayers(2));
        jail.setGame(game);
    }

    static ArrayList<Player> createPlayers(int numPlayers){
        ArrayList<Player> players = new ArrayList<>();

        for(int i = 1; i <= numPlayers; i++){
            System.out.print("Player " + i + " name: ");
            players.add(new Player(Input.read()));
        }

        return players;
    }
}
