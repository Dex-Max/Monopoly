import java.util.ArrayList;

public class Player {
    private final String name;
    private int position;
    private int money;
    private int numUtilities = 0;
    private int numRailroads = 0;
    private ArrayList<Property> properties = new ArrayList<Property>();

    public Player(String name){
        this.name = name;
        position = 0;
    }
    public Square

    public int getPosition() { return position; }

    public String getName() { return name; }

    public void addMoney(int addMoney){
        this.money += addMoney;
    }

    public void pay(Player receiving, int amount){
        receiving.addMoney(amount);
        addMoney(-amount);
    }

    //add property to Player's properties
    public void buy(Property property){
        properties.add(property);
    }

    //move Player
    public void move(int numSquares){
        position += numSquares;

        //if pass GO
        if(position >= 40){
            System.out.println(name + " passed GO and collected $200");
            money += 200;
            position %= 40;
        }
    }

    //check if property is in Player's properties
    private boolean owns(Property property){
        return properties.contains(property);
    }

    public boolean ownsGroup(ColorProperty.Group group, Board board){
        Square currentSquare;

        for(int i = 0; i < 41; i++){
            currentSquare = board.getSquareAt(i);
            if(currentSquare instanceof ColorProperty && ((ColorProperty) currentSquare).getGroup() == group && !owns((ColorProperty) currentSquare)){
                return false;
            }
        }

        return true;
    }
}
