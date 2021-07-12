public class Property extends Purchasable{

    private Group group;

    private int numHouses = 0; //number of houses currently on property
    private int houseCost;

    //rent based on number of houses
    private int rent1;
    private int rent2;
    private int rent3;
    private int rent4;
    private int rentH;

    //TODO make rent double for color-group
    @Override
    public int getRent() {
        switch(numHouses){
            case 0:
                return rent;
            case 1:
                return rent1;
            case 2:
                return rent2;
            case 3:
                return rent3;
            case 4:
                return rent4;
            case 5:
                return rentH;
            default:
                return -1;
        }
    }

    public void buyHouse(){
        owner.addMoney(-houseCost);
        numHouses++;
        System.out.println("Purchased a house on " + name + " for " + houseCost);
    }

    public Group getGroup() { return group; }

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

        switch(group){
            case BROWN:
            case SKY:
                houseCost = 50;
            case PINK:
            case ORANGE:
                houseCost = 100;
            case RED:
            case YELLOW:
                houseCost = 150;
            case GREEN:
            case BLUE:
                houseCost = 200;
        }
    }
}
