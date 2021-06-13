import java.util.ArrayList;

public class Player {
    private String name;
    private int position;
    private int money;
    private ArrayList<Property> properties;

    public Player(String name){
        this.name = name;
        position = 0;
        properties = new ArrayList<Property>();
    }

    //add property to Player's properties
    private void buy(Property property){
        properties.add(property);
    }

    //move Player
    public void move(int numSquares){
        position += numSquares;
    }

    //check if property is in Player's properties
    private boolean owns(Property property){
        return properties.contains(property);
    }
}
