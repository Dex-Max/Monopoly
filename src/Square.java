public abstract class Square {
    protected String name;

    public abstract void landedOn(Player currentPlayer);

    public Square(String name){
        this.name = name;
    }
}
