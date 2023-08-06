import java.util.ArrayList;
import java.util.Scanner;
/*
Program description:
Console program with input validation.
uses: Stream, conditional statements
Gets user to enter numbers and then calculates the mean average of them.
 */


public class averageStream {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        ArrayList<Double> myNumbers = new ArrayList<Double>();

        System.out.print("We will find the average of a set of numbers. To stop entering numbers, just click enter.\n");
        String input = " ";

        //Get values until "" is entered.
        while (true){
            System.out.println("Enter a number:");
            input = myScanner.nextLine();

            if (input.equals("")){
                break;
            }

            //Check if input is number, if it is, add it to list.
            try { myNumbers.add(Double.parseDouble(input));
            } catch (NumberFormatException e) {
                System.out.println("That's not a number, dumdum.");
            }
        }

        //Uses stream to get average as a double value
        double avergae = myNumbers.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .getAsDouble();
        System.out.println("The average is " + avergae);

    }
}
