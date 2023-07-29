import java.util.Scanner;
/*
Program description:
Console program.
uses:
Performs simple mathematics on input recieved by user to find percentages of numbers.
 */

public class Percentages {
    static public void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter a number:\n1._% of _.\n2._ is what percentage of _.\n");
        String option = myScanner.nextLine();
        String firstNum;
        String secondNum;
        double result;

        switch(option){
            case "1": //Find the percentage of a number ((percentage / 100) x number)
                System.out.println("Enter %: ");
                firstNum = myScanner.nextLine();
                System.out.println("Enter number: ");
                secondNum = myScanner.nextLine();
                result = (Double.valueOf(firstNum) / 100)*Double.valueOf(secondNum);
                System.out.println(firstNum + "% of " + secondNum + " is " + result);
                break;
            case "2": //Find what percentage a number is of another number (number / number2 x 100)
                System.out.println("Enter a number:");
                firstNum = myScanner.nextLine();
                System.out.println("Enter another number:");
                secondNum = myScanner.nextLine();
                result = Double.valueOf(firstNum) / Double.valueOf(secondNum) * 100;
                System.out.println(firstNum + " is " + result + "% of " + secondNum);
        }
    }
}
