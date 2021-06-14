public class Property extends Purchasable{

    private Group group;

    private int houseCost;
    //rent based on number of houses
    private int rent1;
    private int rent2;
    private int rent3;
    private int rent4;
    private int rentH;

    //TODO
    @Override
    public int getRent() {
        return 0;
    }

    public enum Group{
        BROWN, SKY, PINK, ORANGE, RED,
            YELLOW, GREEN, BLUE
    }

    public Property(String name, Group group, int price, int rent, int rent1, int rent2, int rent3, int rent4, int rentH){
        super(name, price, rent);
        this.group = group;
        this.rent1 = rent1;
        this.rent2 = rent2;
        this.rent3 = rent3;
        this.rent4 = rent4;
        this.rentH = rentH;
    }
}
