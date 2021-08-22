import java.util.ArrayList;

public class Board {
    private final Square[] board = new Square[40];
    private Deck communityChest = new Deck();
    private Deck chance = new Deck();
    public Jail jail;
    public Dice dice;
    public ArrayList<Player> players;

    public Board(Jail jail, Dice dice, ArrayList<Player> players){
        this.jail = jail;
        this.dice = dice;
        this.players = players;

        //creating all squares on the board
        for(int i = 0; i < 40; i++){
            board[i] = createSquare(i);
            board[i].index = i;
        }

        //create community chest/chance deck
        for(int c = 0; c < 16; c++){
            communityChest.add(createCommunityChestCard(c));
            chance.add(createChanceCard(c));
        }

        communityChest.shuffle();
        chance.shuffle();
    }

    public Square getSquareAt(int position){
        return board[position];
    }

    public Square getCurrentSquare(Player player){
        return getSquareAt(player.getPosition());
    }

    //TODO finish board initialization
    private Square createSquare(int position){
        switch(position){
            case 0:
                return new Square("GO");
            case 1:
                return new ColorProperty("Mediterranean Avenue", ColorProperty.Group.BROWN, 60, 2, 10, 30, 90, 160, 250);
            case 2:
                return new CardDraw(communityChest, "Community Chest");
            case 3:
                return new ColorProperty("Baltic Avenue", ColorProperty.Group.BROWN, 60, 4, 20, 60, 180, 320, 450);
            case 4:
                return new Tax("INCOME TAX", 200);
            case 5:
                return new Railroad("Reading Railroad");
            case 6:
                return new ColorProperty("Oriental Avenue", ColorProperty.Group.SKY, 100, 6, 30, 90, 270, 400, 550);
            case 7:
                return new CardDraw(chance, "Chance");
            case 8:
                return new ColorProperty("Vermont Avenue", ColorProperty.Group.SKY, 100, 6, 30, 90, 270, 400, 550);
            case 9:
                return new ColorProperty("Connecticut Avenue", ColorProperty.Group.SKY, 120, 8, 40, 100, 300, 450, 600);
            case 10:
                return new Square("Just Visiting Jail");
            case 11:
                return new ColorProperty("St. Charles Place", ColorProperty.Group.PINK, 140, 10, 50, 150, 450, 625, 750);
            case 12:
                return new Utility("Electric Company", dice);
            case 13:
                return new ColorProperty("States Avenue", ColorProperty.Group.PINK, 140, 10, 50, 150, 450, 625, 750);
            case 14:
                return new ColorProperty("Virginia Avenue", ColorProperty.Group.PINK, 160, 12, 60, 180, 500, 700, 900);
            case 15:
                return new Railroad("Pennsylvania Railroad");
            case 16:
                return new ColorProperty("St. James Place", ColorProperty.Group.ORANGE, 180, 14, 70, 200, 550, 750, 950);
            case 17:
                return new CardDraw(communityChest, "Community Chest");
            case 18:
                return new ColorProperty("Tennessee Avenue", ColorProperty.Group.ORANGE, 180, 14, 70, 200, 550, 750, 950);
            case 19:
                return new ColorProperty("New York Avenue", ColorProperty.Group.ORANGE, 200, 16, 80, 220, 600, 800, 1000);
            case 20:
                return new Square("Free Parking");
            case 21:
                return new ColorProperty("Kentucky Avenue", ColorProperty.Group.RED, 220, 18, 90, 250, 700, 875, 1050);
            case 22:
                return new CardDraw(chance, "Chance");
            case 23:
                return new ColorProperty("Indiana Avenue", ColorProperty.Group.RED, 220, 18, 90, 250, 700, 875, 1050);
            case 24:
                return new ColorProperty("Illinois Avenue", ColorProperty.Group.RED, 240, 20, 100, 300, 750, 925, 1100);
            case 25:
                return new Railroad("B&O Railroad");
            case 26:
                return new ColorProperty("Atlantic Avenue", ColorProperty.Group.YELLOW, 260, 22, 110, 330, 800, 975, 1150);
            case 27:
                return new ColorProperty("Ventnor Avenue", ColorProperty.Group.YELLOW, 260, 22, 110, 330, 800, 975, 1150);
            case 28:
                return new Utility("Water Works", dice);
            case 29:
                return new ColorProperty("Marvin Gardens", ColorProperty.Group.YELLOW, 280, 24, 120, 360, 850, 1025, 1200);
            case 30:
                return new Square("Go to Jail"){
                    @Override
                    public void doAction(Player currentPlayer){ 
                        jail.sendToJail(currentPlayer);
                    }
                };
            case 31:
                return new ColorProperty("Pacific Avenue", ColorProperty.Group.GREEN, 300, 26, 130, 390, 900, 1100, 1275);
            case 32:
                return new ColorProperty("North Carolina Avenue", ColorProperty.Group.GREEN, 300, 26, 130, 390, 900, 1100, 1275);
            case 33:
                return new CardDraw(communityChest, "Community Chest");
            case 34:
                return new ColorProperty("Pennsylvania Avenue", ColorProperty.Group.GREEN, 320, 28, 150, 450, 1000, 1200, 1400);
            case 35:
                return new Railroad("Short Line");
            case 36:
                return new CardDraw(chance, "Chance");
            case 37:
                return new ColorProperty("Park Place", ColorProperty.Group.BLUE, 350, 35, 175, 500, 1100, 1300, 1500);
            case 38:
                return new Tax("LUXURY TAX", 100);
            case 39:
                return new ColorProperty("Boardwalk", ColorProperty.Group.BLUE, 400, 50, 200, 600, 1400, 1700, 2000);
            default:
                return null;
        }
    }

    private Card createCommunityChestCard(int index){
        switch(index){
            case 0:
                return new MoveToCard(new int[]{0}, this, "Advance to GO");
            case 1:
                return new CollectCard(100, "Life Insurance Matures");
            case 2:
                return new CollectCard(10, "Won Second Prize in a Beauty Contest");
            case 3:
                return new CollectCard(200, "Bank Error in Your Favor");
            case 4:
                return new CollectCard(45, "Sale of Stock");
            case 5:
                return new CollectCard(20, "Income Tax Refund");
            case 6:
                return new CollectCard(25, "Receive For Services");
            case 7:
                return new CollectCard(100, "You Inherit");
            case 8:
                return new CollectCard(100, "Xmas Fund Matures");
            case 9:
                return new CollectEveryCard(players, 50, "Grand Opera Opening");
            case 10:
                return new CollectCard(-50, "Doctor's Fee");
            case 11:
                return new CollectCard(-100, "Hospital Fee");
            case 12:
                return new CollectCard(-150, "School Tax");
            case 13:
                return new HouseRepairCard(40, 115, "Assessed for Street Repairs");
            case 14:
                return new ToJailCard(jail);
            case 15:
                return new OutOfJailCard();
            default:
                return null;
        }
    }

    private Card createChanceCard(int index){
        switch(index){
            case 0:
                return new MoveToCard(new int[]{0}, this, "Advance to GO");
            case 1:
                return new MoveToCard(new int[]{39}, this, "Take a Walk on the Boardwalk");
            case 2:
                return new MoveToCard(new int[]{24}, this, "Advance to Illinois Avenue");
            case 3:
                return new MoveToCard(new int[]{11}, this, "Advance to St. Charles Place");
            case 4:
                return new MoveToCard(new int[]{5}, this, "Take a ride on the Reading Railroad");
            case 5:
            case 6:
                return new MoveToCard(new int[]{5, 15, 25, 35}, this, "Advance to nearest Railroad");
            case 7:
                return new MoveToCard(new int[]{12, 28}, this, "Advance to nearest Utility");
            case 8:
                return new MoveCard(-3, this, "Go Back 3 Spaces");
            case 9:
                return new CollectCard(50, "Bank pays Dividend");
            case 10:
                return new CollectCard(150, "Your Building and Loan Matures");
            case 11:
                return new CollectCard(-15, "Poor Tax");
            case 12:
                return new CollectEveryCard(players, 50, "You Have Been Elected Chairman of the Board");
            case 13:
                return new HouseRepairCard(25, 100, "Make General Repairs on your Property");
            case 14:
                return new ToJailCard(jail);
            case 15:
                return new OutOfJailCard();
            default:
                return null;
        }
    }
}
