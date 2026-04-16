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

}