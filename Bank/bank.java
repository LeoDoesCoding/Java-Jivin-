package Bank;
import java.util.Scanner;
import java.util.ArrayList;
/*
Program description:
Console program with input validation.
uses: Conditional statements, objects, int validation
Gives user a bank account and allows them to deposit, withdraw and view bank balance. Account is an object of Account.java.
 */


public class bank {
    public static Scanner myScanner = new Scanner(System.in);

    public static String scan() {
        return (myScanner.nextLine());
    }
    //public static allows it to be used in main + other methods

    public static void main(String[] args) {
        String input;
        int choice;
        boolean valid;
        ArrayList<Account> accounts = new ArrayList<>();
        int current;
        int value;

        accounts.add(new Account("Mike", 100));
        accounts.add(new Account("Suzy", 100));
        accounts.add(new Account("Andrew", 100));
        accounts.add(new Account("Helen", 100));

        //Loop infinatly
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
                    choice = chooseAccount(accounts, current);
                    //Reject choice if the account is the same as the current one.
                    while (choice == current) {
                        System.out.println("You can't send money to yourself! Chose another account:");
                        choice = chooseAccount(accounts, current);
                    }
                    System.out.println("How much do you want to send?");
                    value = checkIsInt(myScanner.nextLine());
                    valid = accounts.get(current).withdraw(value);
                    //If the ammount has successfully been withdrawn, complete the transfer
                    if (valid) {
                        accounts.get(choice).deposit(value);
                    }
            }
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

    //If not additional account is provided, supply a dummy number (-1)
    public static int chooseAccount(ArrayList<Account> accounts){
        return(chooseAccount(accounts, -1));
    }

    //Presents user with available accounts and validates input (returns int of index of account chosen)
    public static int chooseAccount(ArrayList<Account> accounts, int current) {
        //Prints available accounts
        if (current == -1){ //If not current account, print all accounts.
            for (Account myAccount : accounts) {
                System.out.println(myAccount.getName());
            }
        }else { //Print all names EXCEPT current account being used.
            for (int i = 0; i < current; i++){
                System.out.println(accounts.get(i).getName());
            }
            for (int i = current+1; i < accounts.size(); i++){
                System.out.println(accounts.get(i).getName());
            }
        }

        String input;

        //Validating account name
        while (true) {
            input = myScanner.nextLine();
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getName().equals(input) && i != current) { //If recieved name is valid AND not the account currently logged into (if applicable)
                    return (i); //Return index value of account
                } else if (accounts.get(i).getName().equals(input) && i == current){ //User selected their own account. Dumbass.
                    System.out.println(i);
                    System.out.println("You can't choose your own account!");
                } else if (i == accounts.size()){ //No account of that name found.
                    System.out.println("Invalid account. Enter a name from the above.");
                }
            }
        }
    }
}