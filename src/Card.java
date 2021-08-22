import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Card {
    String message;

    public Card(String message){
        this.message = message;
    }

    public void play(Player player){
        System.out.println(message);
        doAction(player);
    }

    public abstract void doAction(Player player);
}

class CollectCard extends Card {
    int amount;

    public CollectCard(int amount, String message){
        super(message);
        this.amount = amount;
    }

    public void doAction(Player player){
        player.addMoney(amount);
    }
}

class CollectEveryCard extends CollectCard {
    private ArrayList<Player> players;

    public CollectEveryCard(ArrayList<Player> players, int amount, String message){
        super(amount, message);
        this.players = players;
    }

    public void doAction(Player player){
        player.addMoney(amount * players.size());

        for(Player p : players){
            p.addMoney(-amount);
        }
    }
}

class MoveCard extends Card {
    private int numSquares;
    private Board board;

    public MoveCard(int numSquares, Board board, String message){
        super(message);
        this.numSquares = numSquares;
        this.board = board;
    }

    public void doAction(Player player){
        player.move(numSquares, board);
    }
}
class MoveToCard extends Card {
    private int[] index;
    private Board board;

    public MoveToCard(int[] index, Board board, String message){
        super(message);
        this.index = index;
        this.board = board;
    }

    public void doAction(Player player){
        int minimumDistance = 40;

        for(int i = 0; i < index.length; i++){
            int distanceToIndex = (40 + index[i] - player.getPosition()) % 40;
            if ((40 + index[i] - player.getPosition()) < minimumDistance) {
                minimumDistance = distanceToIndex;
            }
        }

        player.move(minimumDistance, board);
    }
}

class HouseRepairCard extends Card {
    private int perHouse;
    private int perHotel;

    public HouseRepairCard(int perHouse, int perHotel, String message){
        super(message);
        this.perHouse = perHouse;
        this.perHotel = perHotel;
    }

    public void doAction(Player player){
        int fee = 0;

        for(ColorProperty p : player.getOwnColorGroupList()){
            if(p.getNumHouses() == 5){
                fee += perHotel;
            } else if (p.getNumHouses() > 0) {
                fee += perHouse;
            }
        }

        player.addMoney(-fee);
    }
}

class ToJailCard extends Card{
    private Jail jail;

    public ToJailCard(Jail jail){
        super("Go Directly To Jail");
        this.jail = jail;
    }

    public void doAction(Player player){
        jail.sendToJail(player);
    }
}

class OutOfJailCard extends Card {
    public OutOfJailCard(){
        super("Get Out Of Jail For Free");
    }
    public void doAction(Player player) {
        player.outOfJailCards++;
    }
}
