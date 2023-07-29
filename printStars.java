import java.util.Scanner;

public class printStars {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int[] myList = new int[3];

        System.out.println("Enter first number:");
        myList[0] = Integer.valueOf(myScanner.nextLine());

        System.out.println("Enter next number:");
        myList[1] = Integer.valueOf(myScanner.nextLine());

        System.out.println("Enter last number:");
        myList[2] = Integer.valueOf(myScanner.nextLine());


        String myString = "";
        for (int i = 0; i <= 2; i++){
            for (int j = 0; j <= myList[i]; j++){
                myString += "*";
            }
            myString += "\n";
        }
        System.out.println(myString);
    }
}