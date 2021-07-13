public class CardDraw extends Square{
    private Card cardType;

    public enum Card{
        COMMUNITY_CHEST, CHANCE
    }

    public CardDraw(Card cardType){
        super(cardType == Card.COMMUNITY_CHEST ? "Community Chest" : "Chance");
        this.cardType = cardType;
    }

    //TODO
    @Override
    public void landedOn(Player p) {

    }
}
