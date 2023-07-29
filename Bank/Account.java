package Bank;
public class Account {
    private int balance;
    private String name;

    //Constructor
    public Account(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

    //Deposits amount
    public void deposit(int amount){
        balance += amount;
        System.out.println(amount + " has been added to " + name + "'s account.");
    }

    //Withdraws amount (if funds are available)
    public boolean withdraw(int amount){
        if (amount > balance){
            System.out.println("Funds not available, sorry.\n");
            return(false);
        }else {
            balance -= amount;
            System.out.println(amount + " has been removed from " + name + "'s account.");
            return(true);
        }
    }

    //Returns balance as int
    public int getBalance(){
        return(balance);
    }

    public String getName(){
        return(name);
    }
}