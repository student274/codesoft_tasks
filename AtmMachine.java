package CodeSoft;
import java.util.Scanner;

public class AtmMachine {

	    private BankAccount userAccount;
	    private Scanner scanner;
	    
	    public AtmMachine(BankAccount userAccount) {
	        this.userAccount = userAccount;
	        this.scanner = new Scanner(System.in);
	    }

	    public void displayMenu() {
	        System.out.println("Welcome to the ATM!");
	        System.out.println("1. Check Balance");
	        System.out.println("2. Deposit");
	        System.out.println("3. Withdraw");
	        System.out.println("4. Exit");
	    }

	    public void processOption(int option) {
	        switch (option) {
	            case 1:
	                System.out.println("Your balance is: " + userAccount.checkBalance());
	                break;
	            case 2:
	                System.out.print("Enter deposit amount: ");
	                double depositAmount = scanner.nextDouble();
	                userAccount.deposit(depositAmount);
	                System.out.println("Deposit successful. Your new balance is: " + userAccount.checkBalance());
	                break;
	            case 3:
	                System.out.print("Enter withdrawal amount: ");
	                double withdrawalAmount = scanner.nextDouble();
	                if (userAccount.withdraw(withdrawalAmount)) {
	                    System.out.println("Withdrawal successful. Your new balance is: " + userAccount.checkBalance());
	                } else {
	                    System.out.println("Insufficient funds. Your current balance is: " + userAccount.checkBalance());
	                }
	                break;
	            case 4:
	                System.out.println("Thank you for using the ATM!");
	                break;
	            default:
	                System.out.println("Invalid option. Please try again.");
	                break;
	        }
	    }

	    public static void main(String[] args) {
	        BankAccount account = new BankAccount();
	        AtmMachine atm = new AtmMachine(account);
	        int option;

	        while (true) {
	            atm.displayMenu();
	            System.out.print("Choose an option (1-4): ");
	            option = atm.scanner.nextInt();
	            if (option == 4) {
	                break;
	            }
	            atm.processOption(option);
	        }

	       
	    }
	}

	class BankAccount {
	    private double balance;

	    public BankAccount() {
	        this.balance = 0.0;
	    }

	    public double checkBalance() {
	        return balance;
	    }

	    public void deposit(double amount) {
	        balance += amount;
	    }

	    public boolean withdraw(double amount) {
	        if (balance >= amount) {
	            balance -= amount;
	            return true;
	        } else {
	            return false;
	        }
	    }
	

		
	}


