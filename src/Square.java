public abstract class Square {
    protected String name;

    public abstract void doAction(Player currentPlayer);

    public String getName() { return name; }

    public Square(String name){
        this.name = name;
    }
}
