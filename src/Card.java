public abstract class Card {
    public abstract void play();
}

class CollectCard extends Card {
    private int amount;
    private String message;

    public void play(){

    }
}

class MoveCard extends Card {
    private int index;

    public void play(){

    }
}
