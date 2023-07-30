package Bank;
import java.util.Scanner;
import java.util.HashMap;
/*
Program description:
Console program with input validation.
uses: Conditional statements, objects, int validation, hashmaps
Gives user a bank account and allows them to deposit, withdraw and view bank balance. Account is an object of Accountv2.java.
 */


public class bankv2 {
    public static Scanner myScanner = new Scanner(System.in);

    public static String scan() {
        return (myScanner.nextLine());
    }
    //public static allows it to be used in main + other methods

    public static void main(String[] args) {
        String input;
        int choice;
        boolean valid;
        HashMap<String, Accountv2> accounts = new HashMap<>();
        String current;
        int value;

        //Populate bank accounts
        accounts.put("Mike", new Accountv2("Mike", 100));
        accounts.put("Suzy", new Accountv2("Suzy", 100));
        accounts.put("Andrew", new Accountv2("Andrew", 100));
        accounts.put("Helen", new Accountv2("Helen", 100));

        //Main program. Loops infinatly
        while (true) {
            System.out.println("Whose account do you want to access?");
            current = chooseAccount(accounts); //Get account as index value from string value
            System.out.println("Logged into " + accounts.get(current).getName() + "'s account.");

            System.out.println("What would you like to do? (Enter a number)\n1. Deposit\n2. Withdraw\n3. View balance\n4. Transfer");
            choice = checkIsInt(myScanner.nextLine());
            valid = false;

            //Checks input is valid (first using the checkIsInt function, then that it is in range 1-3)
            while (!valid) {
                valid = true;
                //Check it is in range 1-3
                if (choice < 0 || choice > 4) {
                    System.out.println("Invalid choice. Please enter a number 1-3:");
                    choice = checkIsInt(myScanner.nextLine());
                    ;
                    valid = false;
                }
            }

            //Gives user different istructions/actions based on choice.
            switch (choice) {
                case 1: //Deposit any number
                    System.out.println("Enter an amount to deposit: ");
                    accounts.get(current).deposit(checkIsInt(myScanner.nextLine()));
                    break;
                case 2: //Withdraw any number equal or lower to account balance
                    System.out.println("Enter an amount to withdraw: ");
                    accounts.get(current).withdraw(checkIsInt(myScanner.nextLine()));
                    break;
                case 3: //View balance
                    System.out.println("You have " + String.valueOf(accounts.get(current).getBalance()) + " in your account.\n");
                    break;
                case 4: //Transfer funds
                    System.out.println("Whose account do you want to transfer money to?");
                    input = chooseAccount(accounts, current);
                    System.out.println("How much do you want to send?");
                    choice = checkIsInt(myScanner.nextLine());
                    accounts.get(current).transfer(accounts.get(input), choice);
            }
            System.out.println("\n");
        }
    }


    //Checks input is int, forces user to enter until it is (returns int of input)
    public static int checkIsInt(String input){
        boolean valid = false;
        while (!valid) {
            valid = true;
            try {
                Integer.parseInt(input);
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input. Please enter a number:");
                valid = false;
                input = myScanner.nextLine();
            }
        }
        return (Integer.valueOf(input));
    }

    //If not additional account is provided, supply an empty name for secondary account
    public static String chooseAccount(HashMap<String, Accountv2> accounts){
        return(chooseAccount(accounts, ""));
    }


    //Presents user with available accounts and validates input
    public static String chooseAccount(HashMap<String, Accountv2> accounts, String current) {

        //Prints available accounts
        for (String myAccount : accounts.keySet()) {
            if (!myAccount.equals(current)) {
                System.out.println(myAccount);
            }
        }

        String input;

        //Validating account name
        while (true) {
            input = myScanner.nextLine();
            if (accounts.containsKey(input)){ //Check account exists
                if (input.equals(current)){ //If trying to choose a secondary account for action that is same as current, reject.
                    System.out.println("You can't choose your own account!\nPlease choose a valid account from the above.");
                } else{
                    return(input);
                }
            } else { //No account of the name found
                System.out.println("Invalid account. Enter a name from the above.");
            }
        }
    }
}