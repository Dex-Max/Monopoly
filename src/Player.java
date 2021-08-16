import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Player {
    private final String name;
    public boolean inJail = false;
    public int turnsInJail = 0;
    private int position;
    private int money = 1500;
    private int numUtilities = 0;
    private int numRailroads = 0;
    private ArrayList<Property> properties = new ArrayList<Property>();

    public Player(String name){
        this.name = name;
        position = 0;
    }

    public int getPosition() { return position; }

    public String getName() { return name; }

    public int getMoney() { return money; }

    public void addMoney(int addMoney){
        this.money += addMoney;
    }

    public void pay(Player receiving, int amount){
        receiving.addMoney(amount);
        addMoney(-amount);
    }

    public void move(int numSquares, Board board){
        position += numSquares;

        //if pass GO
        if(position >= 40){
            System.out.println(name + " passed GO and collected $200");
            money += 200;
            position %= 40;
        }

        System.out.println("Landed on " + board.getCurrentSquare(this));
        board.getCurrentSquare(this).doAction(this);
    }

    public void sendToJail(Game game){
        EndTurnOption endTurnOption = new EndTurnOption(game, this);
        inJail = true;
        position = 10;
        endTurnOption.action();
    }

    //add property to Player's properties
    public void buy(Property property){
        addMoney(-property.getPrice());
        properties.add(property);
        sortPropertiesByGroup(properties);
    }

    private void sortPropertiesByGroup(ArrayList<Property> properties){
        ArrayList<Utility> utilities = new ArrayList<>();
        ArrayList<Railroad> railroads = new ArrayList<>();
        ArrayList<Property> sorted = new ArrayList<>();

        for(Property property : properties){
            if(property instanceof Utility){
                utilities.add((Utility) property);
            } else if(property instanceof Railroad){
                railroads.add((Railroad) property);
            } else {
                sorted.add(property);
            }
        }
        Collections.sort(utilities);
        Collections.sort(railroads);
        Collections.sort(sorted);

        sorted.addAll(railroads);
        sorted.addAll(utilities);
    }

    public void listProperties(){
        if(properties.isEmpty()){
            System.out.println("You do not own any properties");
        }
        for(Property property : properties){
            System.out.println(property);
        }
    }

    //returns list of all properties that Player owns color group
    public ArrayList<ColorProperty> getOwnColorGroupList(){
        ArrayList<ColorProperty> list = new ArrayList<>();
        for(Property property: properties){
            if(property instanceof ColorProperty && ownsGroup(((ColorProperty) property).getGroup())){
                list.add((ColorProperty) property);
            }
        }
        return list;
    }

    //return list of all properties that Player can place house
    public ArrayList<ColorProperty> getHouseableProperties(){
        getOwnColorGroupList().removeIf(property -> property.getNumHouses() == 5);
        return getOwnColorGroupList();
    }

    //check if property is in Player's properties
    private boolean owns(Property property){
        return properties.contains(property);
    }

    //check if Player owns all of a certain color group
    public boolean ownsGroup(ColorProperty.Group group){
        int count = 0;

        for(Property property : properties){
            if(property instanceof ColorProperty && ((ColorProperty) property).getGroup() == group){
                count++;
            }
        }

        return (count == group.maxInGroup);
    }
}
