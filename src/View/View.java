package View;

import java.util.Scanner;

public class View {

    private final Scanner scanner = new Scanner(System.in);

    public int initialView() {
        String option;
        do{
            System.out.println("-----------------------------------------------");
            System.out.println("\tWelcome to PizziSalle");
            System.out.println("-----------------------------------------------");
            System.out.println("\t[1] - Start an order");
            System.out.println("\t[2] - Exit");
            System.out.print("Select an option: ");
            option = scanner.nextLine();
            System.out.println("");
        }while(option.compareTo("1") != 0 && option.compareTo("2") != 0);
        return Integer.parseInt(option);
    }

    public int newOrder() {
        String option;
        do{
            System.out.println("-----------------------------------------------");
            System.out.println("\tCreate a new order");
            System.out.println("-----------------------------------------------");
            System.out.println("\t[1]- Add Pizza");
            System.out.println("\t[2]- Add Soft Drink");
            System.out.println("\t[3]- Place order");
            System.out.println("\t[4]- Exit");
            System.out.print("Select an option: ");
            option = scanner.nextLine();
            System.out.println("");
        }while(option.compareTo("1") != 0 && option.compareTo("2") != 0
                && option.compareTo("3") != 0 && option.compareTo("4") != 0);

        return Integer.parseInt(option);
    }

    public void exit(){
        System.out.println("Bye!");
    }


}
