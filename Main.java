import java.util.Scanner;
import java.util.Vector;


public class Main {
	
    public static Scanner sc = new Scanner(System.in);
    static Vector<Bank> allBank = new Vector<Bank>();
    static Vector<User> allUser = new Vector<User>();

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
	
    static void handleBankSection() {
        int choice;
        do {
            System.out.println("\n--- Bank Section ---");
            System.out.println("1) Add New Bank");
            System.out.println("2) Existing Bank");
            System.out.println("3) Back");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                String bankName, securityString;
                int balance;
                System.out.print("Enter Bank Name: ");
                bankName = sc.nextLine();
                System.out.print("Set Security String: ");
                securityString = sc.nextLine();
                System.out.print("Set first Balance: ");
                balance = sc.nextInt();
                sc.nextLine();

                if (balance == 0) {
                    allBank.add(new Bank(bankName, securityString));
                } else {
                    allBank.add(new Bank(bankName, securityString, balance));
                }
                System.out.println("Bank Added Successfully!!");
            } else if (choice == 2) {
                if (allBank.isEmpty()) {
                    System.out.println("No banks exist yet!");
                    continue;
                }

                System.out.println("Existing Banks (" + allBank.size() + "):");
                for (int i = 0; i < allBank.size(); i++) {
                    System.out.println(i + ") " + allBank.get(i).name);
                }
                System.out.print("Select bank: ");
                int bankChoice = sc.nextInt();
                sc.nextLine();

                if (bankChoice >= 0 && bankChoice < allBank.size()) {
                    handleEachBank(allBank.get(bankChoice));
                } else {
                    System.out.println("Wrong Input, Try Again!!!");
                }
            } else if (choice == 3) {
                return;
            } else {
                System.out.println("Wrong Input, Try Again!!!");
            }
        } while (true);
    }
    static void handleEachUser(User user) {
        int choice;
        do {
            System.out.println("\n--- User: " + user.name + " ---");
            System.out.println("1) Register to a Bank");
            System.out.println("2) Display All Accounts");
            System.out.println("3) Deposit Money");
            System.out.println("4) Withdraw Money");
            System.out.println("5) Check Balance");
            System.out.println("6) Back");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (allBank.isEmpty()) {
                        System.out.println("No banks available for registration!");
                        break;
                    }

                    System.out.println("Available Banks:");
                    for (int i = 0; i < allBank.size(); i++) {
                        System.out.println(i + ") " + allBank.get(i).name);
                    }
                    System.out.print("Select bank: ");
                    int bankChoice = sc.nextInt();
                    sc.nextLine();

                    if (bankChoice >= 0 && bankChoice < allBank.size()) {
                        String accountNumber = user.registerToBank(allBank.get(bankChoice));
                        System.out.println("Your new account number: " + accountNumber);
                    } else {
                        System.out.println("Invalid bank selection!");
                    }
                    break;

                case 2:
                    user.displayAccounts();
                    break;

                case 3:
                    if (allBank.isEmpty()) {
                        System.out.println("No banks available!");
                        break;
                    }

                    System.out.println("Select Bank:");
                    for (int i = 0; i < allBank.size(); i++) {
                        System.out.println(i + ") " + allBank.get(i).name);
                    }
                    System.out.print("Enter bank number: ");
                    int depositBank = sc.nextInt();
                    sc.nextLine();

                    if (depositBank >= 0 && depositBank < allBank.size()) {
                        Bank selectedBank = allBank.get(depositBank);
                        System.out.print("Enter account number: ");
                        String accNum = sc.nextLine();
                        System.out.print("Enter amount to deposit: ");
                        int depositAmount = sc.nextInt();
                        sc.nextLine();

                        user.deposit(selectedBank, accNum, depositAmount);
                    } else {
                        System.out.println("Invalid bank selection!");
                    }
                    break;

                case 4:
                    if (allBank.isEmpty()) {
                        System.out.println("No banks available!");
                        break;
                    }

                    System.out.println("Select Bank:");
                    for (int i = 0; i < allBank.size(); i++) {
                        System.out.println(i + ") " + allBank.get(i).name);
                    }
                    System.out.print("Enter bank number: ");
                    int withdrawBank = sc.nextInt();
                    sc.nextLine();

                    if (withdrawBank >= 0 && withdrawBank < allBank.size()) {
                        Bank selectedBank = allBank.get(withdrawBank);
                        System.out.print("Enter account number: ");
                        String accNum = sc.nextLine();
                        System.out.print("Enter amount to withdraw: ");
                        int withdrawAmount = sc.nextInt();
                        sc.nextLine();

                        user.withdraw(selectedBank, accNum, withdrawAmount);
                    } else {
                        System.out.println("Invalid bank selection!");
                    }
                    break;

                case 5:
                    System.out.println("Feature to be implemented: Check Balance");
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Wrong Input, Try Again!!!");
            }
        } while (true);
    }		
}
