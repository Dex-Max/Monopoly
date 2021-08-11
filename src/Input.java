import java.util.ArrayList;
import java.util.Scanner;

public class Input {


    public String read(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    //outputs numbered list of options and returns the selected one
    public Object selectOptions(ArrayList<?> list, String message){
        int input = -1;

        if(list.size() == 0) return null;

        System.out.println(message + " (Enter a number 1 - " + list.size() + ")");

        for(int i = 1; i <= list.size(); i++){
            System.out.println(i + ". " + list.get(i - 1).toString());
        }

        try {
            input = Integer.parseInt(read());
        } catch(NumberFormatException e){
            System.out.println("Enter a valid number");
            selectOptions(list, message);
        }

        return list.get(input - 1);
    }
}
