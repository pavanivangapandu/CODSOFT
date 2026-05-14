import java.util.Scanner;
public class ATMInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter Initial Balance: ");
        double initialBalance = sc.nextDouble();

        
        BankAccount userAccount = new BankAccount(initialBalance);

        
        ATM atm = new ATM(userAccount);


        atm.displayMenu();

        sc.close();
    }
}

class BankAccount {

    double balance;

   
    BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    
    void deposit(double amount) {

        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount Deposited Successfully.");
        } else {
            System.out.println("Invalid Amount.");
        }
    }

    
    void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Amount.");
        } 
        else if (amount > balance) {
            System.out.println("Insufficient Balance.");
        } 
        else {
            balance = balance - amount;
            System.out.println("Please collect your cash.");
        }
    }

    
    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}


class ATM {

    BankAccount account;

    
    ATM(BankAccount account) {
        this.account = account;
    }

   
    void displayMenu() {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    account.checkBalance();
                    break;

                case 2:

                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();

                    account.deposit(depositAmount);
                    break;

                case 3:

                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();

                    account.withdraw(withdrawAmount);
                    break;

                case 4:

                    System.out.println("Thank you for using ATM.");
                    break;

                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}


