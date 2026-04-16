import java.util.*;

public class User {
    public String name;

    private String password;

    // Bank -> Set of account numbers in that bank
    private Map<Bank, Set<String>> bankAccounts;

    private Scanner sc;

    User(String password, String name) {
        this.name = name;
        this.password = password;
        this.bankAccounts = new HashMap<>();
        this.sc = new Scanner(System.in);
    }
    // Register user in a bank
    String registerToBank(Bank bank) {
        System.out.print("Set Account Password: ");
        String accountPassword = sc.nextLine();

        String accountNumber = bank.addUser(accountPassword);

        if (!bankAccounts.containsKey(bank)) {
            bankAccounts.put(bank, new HashSet<>());
        }

        Set<String> accounts = bankAccounts.get(bank);
        accounts.add(accountNumber);

        System.out.println("Registration Successful!");
        return accountNumber;
    }
    // Display all accounts of the user
    void displayAccounts() {
        if (bankAccounts.isEmpty()) {
            System.out.println("No bank accounts found!");
            return;
        }

        for (Map.Entry<Bank, Set<String>> entry : bankAccounts.entrySet()) {
            System.out.println("Bank: " + entry.getKey());
            for (String acc : entry.getValue()) {
                System.out.println("  Account No: " + acc);
            }
        }
    }

    // Check if user has account in a bank
    boolean hasBank(Bank bank) {
        return bankAccounts.containsKey(bank);
    }

    // Deposit money
    void deposit(Bank bank, String accountNumber, int amount) {
        if (!hasBank(bank)) {
            System.out.println("User not registered in this bank!");
            return;
        }

        if (bank.deposit(accountNumber, amount)) {
            System.out.println("Deposit Successful!");
        } else {
            System.out.println("Deposit Failed!");
        }
    }

    // Withdraw money
    void withdraw(Bank bank, String accountNumber, int amount) {
        if (!hasBank(bank)) {
            System.out.println("User not registered in this bank!");
            return;
        }

        if (bank.withdraw(accountNumber, amount)) {
            System.out.println("Withdrawal Successful!");
        } else {
            System.out.println("Withdrawal Failed!");
        }
    }
}
