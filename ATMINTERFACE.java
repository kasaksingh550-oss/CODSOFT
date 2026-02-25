
import java.util.Scanner;

class BankAccount {
    private double balance;
    public BankAccount(double initialBalance){
        balance = initialBalance;

    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
    balance += amount;
    }

    public boolean withdraw(double amount){
        if(amount<=balance){
            balance -= amount;
            return true;

        }else {
            return false;
        }
    }

}

// class to repersent atm machine
class ATM{
     private BankAccount account;
     public ATM(BankAccount account){
         this.account = account;
     }
     public void displayMenu(){
         System.out.println("\n==== ATM MENU ====");
         System.out.println("1. Check Balance");
     System.out.println("2. Deposit");
         System.out.println("3. Withdraw");
         System.out.println("4. Exit");
         System.out.println("Enter your choice");

     }

     public void checkBalance() {
         System.out.println("The balance is " + account.getBalance());
     }
     public void deposit(double amount) {
         if(amount <=0){
             System.out.println("Invalid Deposit amount!");
             return;
         }
         account.deposit(amount);
         System.out.println("Deposite successful" + amount);
     }
     public void withdraw(double amount) {
         if(amount <=0) {
             System.out.println("Invalid Withdraw amount!");
             return;


         }
         if(account.withdraw(amount)){
             System.out.println("Withdraw successful" + amount);

         }else{
             System.out.println("Insufficient balance!");
         }
     }

}
// Main Class
public class ATMINTERFACE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(10000);
        ATM atm = new ATM(userAccount);
        int choice;
        do {
            atm.displayMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.println("Enter amount to deposit");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Enter amount to withdraw");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("thank you for using the ATM");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again!");
            }
            }while (choice != 4) ;
            sc.close();
        }
    }

