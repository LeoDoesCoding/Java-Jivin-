package Bank;
public class Accountv2 {
    private int balance;
    private String name;

    //Constructor
    public Accountv2(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

    //Deposits amount
    public void deposit(int amount){
        balance += amount;
        System.out.println(amount + " has been added to " + name + "'s account.");
    }

    //Withdraws amount (if funds are available)
    public void withdraw(int amount){
        if (amount > balance){
            System.out.println("Funds not available, sorry.\n");
            return;
        }else {
            balance -= amount;
            System.out.println(amount + " has been removed from " + name + "'s account.");
            return;
        }
    }

    //Transfers funds (if available) to recipient account
    public void transfer(Accountv2 to, int toTransfer){
        if (this.balance < toTransfer){
            System.out.println("Sorry, insificient funds. No money was transfered.");
            return;
        } else { //Remove funds from account, deposit in secondary
            this.withdraw(toTransfer);
            to.deposit(toTransfer);
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