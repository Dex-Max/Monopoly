import java.util.LinkedList;

public class Deck <T extends Card> {
    private LinkedList<T> deck = new LinkedList<>();

    //plays top card and puts it on bottom of deck
    public void playTop(){
        T topCard = deck.removeFirst();
        deck.addLast(topCard);
        topCard.play();
    }
}
