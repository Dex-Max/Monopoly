public abstract class Property extends Square {
    protected int price;
    protected int rent;
    protected Player owner = null;

    public Property(String name, int price, int rent){
        super(name);
        this.price = price;
        this.rent = rent;
    }

    public abstract int getRent();

    @Override
    public void doAction(Player currentPlayer) {
        if(currentPlayer == owner);
            //square is owned by the currentPlayer
        else if(owner != null) {
            //square is owned by someone else
            currentPlayer.pay(owner, getRent());
        } else {
            //square can be bought
            offerBuy(currentPlayer);
        }
    }

    //TODO Get user input
    public void offerBuy(Player currentPlayer){
        System.out.println("Would you like to buy " + name + " for $" + price + "?");
        String response = "";

        if(response == "y"){
            currentPlayer.buy(this);
            owner = currentPlayer;

        }
    }
}
