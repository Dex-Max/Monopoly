public class Dice {
    private int roll1;
    private int roll2;

    public int roll(){
        System.out.print("Press enter to roll");
        Input.read();

        roll1 = (int) (Math.random() * 6 + 1);
        roll2 = (int) (Math.random() * 6 + 1);

        System.out.println("Rolled a " + roll1 + " and " + roll2);
        return roll1 + roll2;
    }

    //uses value of the dice without rolling
    public int currentRoll(){
        return roll1 + roll2;
    }

    public boolean isDouble(){
        return roll1 == roll2;
    }
}
