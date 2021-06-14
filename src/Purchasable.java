public abstract class Purchasable extends Square {
    protected int price;
    protected int rent;
    protected Player owner = null;

    public Purchasable(String name, int price, int rent){
        super(name);
        this.price = price;
        this.rent = rent;
    }

    @Override
    public void landedOn() {
        getRent();
    }

    public abstract int getRent();
}
