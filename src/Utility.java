public class Utility extends Property {
    private  Dice dice;

    public Utility(String name, Dice dice){
        super(name, 150, 0);
        this.dice = dice;
    }

    @Override
    public int getRent() {
        int rent;
        int roll = dice.currentRoll();

        switch(owner.getNumUtilities()){
            case 1:
                rent = 4 * roll;
                break;
            case 2:
                rent = 10 * roll;
                break;
            default:
                rent = -1;
                break;
        }

        return rent;
    }
}
