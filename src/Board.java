public class Board {
    private final Square[] board = new Square[40];

    public Board(){
        //creating all squares on the board
        for(int i = 0; i < 40; i++){
            board[i] = createSquare(i);
        }

        //create community chest/chance deck
    }

    public Square getSquareAt(int position){
        return board[position];
    }

    //TODO finish board initialization
    private Square createSquare(int position){
        switch(position){
            case 0:
                return null;
            case 1:
                return new ColorProperty("Mediterranean Avenue", ColorProperty.Group.BROWN, 60, 2, 10, 30, 90, 160, 250);
            case 2:
            case 3:
                return new ColorProperty("Baltic Avenue", ColorProperty.Group.BROWN, 60, 4, 20, 60, 180, 320, 450);
            case 4:
                return new Tax("INCOME TAX", 200);
            case 5:
                return new Railroad("Reading Railroad");
            case 6:
                return new ColorProperty("Oriental Avenue", ColorProperty.Group.SKY, 100, 6, 30, 90, 270, 400, 550);
            case 7:
                return new CardDraw(CardDraw.Card.CHANCE);
            case 8:
                return new ColorProperty("Vermont Avenue", ColorProperty.Group.SKY, 100, 6, 30, 90, 270, 400, 550);
            case 9:
                return new ColorProperty("Connecticut Avenue", ColorProperty.Group.SKY, 120, 8, 40, 100, 300, 450, 600);
            case 10:
                return null;
            case 11:
                return new ColorProperty("St. Charles Place", ColorProperty.Group.PINK, 140, 10, 50, 150, 450, 625, 750);
            case 12:
                return new Utility("Electric Company");
            case 13:
                return new ColorProperty("States Avenue", ColorProperty.Group.PINK, 140, 10, 50, 150, 450, 625, 750);
            case 14:
                return new ColorProperty("Virginia Avenue", ColorProperty.Group.PINK, 160, 12, 60, 180, 500, 700, 900);
            case 15:
                return new Railroad("Pennsylvania Railroad");
            case 16:
                return new ColorProperty("St. James Place", ColorProperty.Group.ORANGE, 180, 14, 70, 200, 550, 750, 950);
            case 17:
                return new CardDraw(CardDraw.Card.COMMUNITY_CHEST);
            case 18:
                return new ColorProperty("Tennessee Avenue", ColorProperty.Group.ORANGE, 180, 14, 70, 200, 550, 750, 950);
            case 19:
                return new ColorProperty("New York Avenue", ColorProperty.Group.ORANGE, 200, 16, 80, 220, 600, 800, 1000);
            case 20:
                return null;
            case 21:
                return new ColorProperty("Kentucky Avenue", ColorProperty.Group.RED, 220, 18, 90, 250, 700, 875, 1050);
            case 22:
                return new CardDraw(CardDraw.Card.CHANCE);
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
                return new Utility("Water Works");
            case 29:
                return new ColorProperty("Marvin Gardens", ColorProperty.Group.YELLOW, 280, 24, 120, 360, 850, 1025, 1200);
            case 30:
                return null;
            case 31:
                return new ColorProperty("Pacific Avenue", ColorProperty.Group.GREEN, 300, 26, 130, 390, 900, 1100, 1275);
            case 32:
                return new ColorProperty("North Carolina Avenue", ColorProperty.Group.GREEN, 300, 26, 130, 390, 900, 1100, 1275);
            case 33:
                return new CardDraw(CardDraw.Card.COMMUNITY_CHEST);
            case 34:
                return new ColorProperty("Pennsylvania Avenue", ColorProperty.Group.GREEN, 320, 28, 150, 450, 1000, 1200, 1400);
            case 35:
                return new Railroad("Short Line");
            case 36:
                return new CardDraw(CardDraw.Card.CHANCE);
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
}
