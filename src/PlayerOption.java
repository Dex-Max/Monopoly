/*
interface Option {
    public void action();

    public String toString();
}

 */

public abstract class PlayerOption {
    String message;

    public PlayerOption(String message){
        this.message = message;
    }

    abstract public void action();

    public String toString(){
        return message;
    }
}

class RollOption extends PlayerOption{
    Dice dice;

    public RollOption(Dice dice){
        super("Roll");
        this.dice = dice;
    }

    public void action(){
        dice.roll();
    }
}

class ListPropertiesOption extends PlayerOption{
    Player player;

    public ListPropertiesOption(Player currentPlayer){
        super("List Properties");
        player = currentPlayer;
    }

    public void action(){
        player.listProperties();
    }
}

class BuyHouseOption extends PlayerOption{
    Player player;
    Input input;

    public BuyHouseOption(Player currentPlayer, Input input){
        super("Buy Houses");
        player = currentPlayer;
        this.input = input;
    }

    public void action(){
        ColorProperty houseProperty = (ColorProperty) input.selectOptions(player.getHouseableProperties(), "");

        if(houseProperty == null){
            System.out.println("You do not have any properties to place a house on");
        } else {
            System.out.println("Select property to purchase house on: ");
            houseProperty.addHouse();
        }
    }
}

class EndTurnOption extends PlayerOption{
    public EndTurnOption(){
        super("End Turn");
    }

    public void action(){

    }
}
