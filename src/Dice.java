public class Dice {
    public int roll1;
    public int roll2;

    public int roll(Input input){
        System.out.print("Press enter to roll");
        input.read();

        roll1 = (int) (Math.random() * 6 + 1);
        roll2 = (int) (Math.random() * 6 + 1);

        System.out.println("Rolled a " + roll1 + " and " + roll2);
        return roll1 + roll2;
    }
}
