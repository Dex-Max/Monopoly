import java.util.ArrayList;
import java.util.Scanner;

public class Input {


    public String read(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public Object selectOptions(ArrayList<?> list){
        int input = -1;

        for(int i = 1; i <= list.size(); i++){
            System.out.println(i + ". " + list.get(i).toString());
        }
        try {
            input = Integer.parseInt(read());
        } catch(NumberFormatException e){
            System.out.println("Enter a valid number");
            selectOptions(list);
        }

        return list.get(input);
    }
}
