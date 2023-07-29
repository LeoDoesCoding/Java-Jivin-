import java.util.Scanner;
/*
Program description:
Console program.
Uses: string.split, item.contains
Recieves a sentence string from the user and outputs words containing "av".
 */

public class avClub {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = myScanner.nextLine();

        //If input is not empty, check for "av"
        if (!input.equals("")){
            String[] splitString = input.split(" ");
            for (String item : splitString){
                if(item.contains("av")){
                    System.out.println(item);
                }
            }
        }
    }
}