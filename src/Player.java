import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Player {
    private ArrayList<Property> properties = new ArrayList<Property>();
    private final String name;
    private int position;
    private int money = 1500;

    public boolean inJail = false;
    public int outOfJailCards = 0;
    public int turnsInJail = 0;

    public Player(String name){
        this.name = name;
        position = 0;
    }

    public String getName() { return name; }

    public int getPosition() { return position; }

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

    public void moveTo(int toPosition, Board board){
        move((40 - position + toPosition) % 40, board);
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

    public int getNumRailroads(){
        int numRailroads = 0;
        for(Property p : properties){
            if(p instanceof Railroad){
                numRailroads++;
            }
        }

        return numRailroads;
    }

    public int getNumUtilities(){
        int numUtilities = 0;
        for(Property p : properties){
            if(p instanceof Utility){
                numUtilities++;
            }
        }

        return numUtilities;
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
        ArrayList<ColorProperty> houseable = new ArrayList<>();
        for(ColorProperty i : getOwnColorGroupList()){
            boolean lowestHouses = true;

            for(ColorProperty j : getOwnColorGroupList()){
                if(i.getGroup() == j.getGroup() && i.getNumHouses() > j.getNumHouses()){
                    lowestHouses = false;
                }
            }

            if(lowestHouses && i.getNumHouses() != 5){
                houseable.add(i);
            }
        }

        return houseable;
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
