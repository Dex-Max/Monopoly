import java.util.Scanner;

public abstract class Property extends Square {
    private final int price;
    private final int rent;
    private Player owner = null;

    public Property(String name, int price, int rent){
        super(name);
        this.price = price;
        this.rent = rent;
    }

    public Player getOwner() {
        return owner;
    }
    public int getPrice(){
        return price;
    }

    public abstract int getRent();

    @Override
    public void doAction(Player currentPlayer) {
        if(currentPlayer == owner);
            //square is owned by the currentPlayer
        else if(owner != null) {
            //square is owned by someone else
            System.out.println(currentPlayer.getName() + " paid " + owner.getName() + " $" + getRent() + " in rent");
            currentPlayer.pay(owner, getRent());
        } else {
            //square can be bought
            offerBuy(currentPlayer);
        }
    }

    public void offerBuy(Player currentPlayer){
        System.out.println("Would you like to buy " + name + " for $" + price + "?");
        String response = Input.read().toLowerCase();

        if(response.contains("y")){
            currentPlayer.buy(this);
            owner = currentPlayer;
        }
    }
}
