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
    public int getPosition(){ return position; }

    public void addMoney(int addMoney){
        this.money += addMoney;
    }

    //add property to Player's properties
    private void buy(Property property){
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
}
