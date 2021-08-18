public class Square implements Comparable<Square>{
    protected int index;
    protected final String name;

    public Square(String name){
        this.name = name;
    }

    public void doAction(Player currentPlayer){};

    public String toString(){
        return name;
    }

    public int compareTo(Square s){
        if(index < s.index){
            return -1;
        } else if (index == s.index){
            return 0;
        } else {
            return 1;
        }
    }
}
