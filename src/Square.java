public class Square implements Comparable<Square>{
    int index;

    final String name;

    public void doAction(Player currentPlayer) {};

    public String getName() { return name; }

    public Square(String name){
        this.name = name;
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
