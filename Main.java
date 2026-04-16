import java.util.Scanner;
import java.util.Vector;


public class Main {
	
	static void handleEachBank(Bank bank) {
        int choice;
        do {
            System.out.println("\n--- Bank: " + bank.name + " ---");
            System.out.println("1) List all Users");
            System.out.println("2) List Bank Balance");
            System.out.println("3) Withdraw");
            System.out.println("4) Back");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                bank.displayAllUsers();
            } else if (choice == 2) {
                bank.getBankBalance();
            } else if (choice == 3) {
                System.out.print("Account number: ");
                String acc = sc.nextLine();
                System.out.print("Amount: ");
                int amt = sc.nextInt();
                sc.nextLine();
                bank.withdraw(acc, amt);
            } else if (choice == 4) {
                return;
            } else {
                System.out.println("Wrong input!");
            }
        } while (true);
    }
	
}
