import java.util.*;

class BankAccount {
    private int balance;

    public BankAccount(int initialAmount) {
        this.balance = initialAmount;
    }

    public int balance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid entry! please choose a number above 0");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount < -balance) {
            System.out.println("withdraw successful of" + amount + "Rs");
            amount -= balance;
        } else {
            System.out.println("invalid entry! insufficient balance or negative value entered... ");
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void display() {
        System.out.println("select options");
        System.out.println("1.deposit");
        System.out.println("2.withdraw");
        System.out.println("3.checkbalance");
        System.out.println("4.Level");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            display();
            System.out.println("pick an option");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter amount to deposit");
                    int depositAmount = sc.nextInt();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw");
                    int withdrawAmount = sc.nextInt();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("current balance" + account.balance());
                case 4:
                    System.out.println("thanks for working with jain banks");
                    break;
                default:
                    System.out.println("invalid entry! entry only the given option");

            }
        } while (option != 4);
        sc.close();
    }
}

public class Task3 {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(30000);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
