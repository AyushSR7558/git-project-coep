import java.util.*;

class Bank {
    public String name;
    private int balance;
    private final String securityString;
    private Map<String, Account> accountNumber;
    private Scanner sc;

    void getBankBalance() {
        System.out.println("Enter the Security String:- ");
        String temp = sc.nextLine();
        if (securityString.equals(temp)) {
            System.out.println("Balance:- " + balance);
        } else {
            System.out.println("Wrong String Entered");
        }
    }

    Bank(String name, String securityString) {
        this.name = name;
        this.securityString = securityString;
        this.balance = 0;
        this.accountNumber = new HashMap<>();
        this.sc = new Scanner(System.in);
    }

    Bank(String name, String securityString, int balance) {
        this.name = name;
        this.securityString = securityString;
        this.balance = balance;
        this.accountNumber = new HashMap<>();
        this.sc = new Scanner(System.in);
    }
    //Generate unique account number
    private String generateAccountNumber() {
        return UUID.randomUUID().toString();
    }

    String addUser(String accountPassword) {
        String userAccountNumber = generateAccountNumber();
        accountNumber.put(userAccountNumber, new Account(accountPassword));
        return userAccountNumber;
    }


    // Authentication (INFINITE LOOP)
    boolean auth(Account user) {
        while (true) {
            System.out.print("Enter the Password: ");
            String enteredPassword = sc.nextLine();
            if(enteredPassword.equals("###")) {
                return false;
            }
            if (user.getPassword().equals(enteredPassword)) {
                return true;
            } else {
                System.out.println("Wrong password! Try again.");
            }
        }
    }

    // Deposit money
    boolean deposit(String accNumber, int amount) {
        if (!accountNumber.containsKey(accNumber)) {
            System.out.println("Account not found!");
            return false;
        }

        Account user = accountNumber.get(accNumber);

        if (auth(user)) {
            user.balance += amount;
            balance += amount;
            return true;
        }
        return false;
    }

    // Withdraw money
    boolean withdraw(String accNumber, int amount) {
        if (!accountNumber.containsKey(accNumber)) {
            System.out.println("Account not found!");
            return false;
        }

        Account user = accountNumber.get(accNumber);

        if (auth(user)) {
            if (user.balance < amount) {
                System.out.println("Insufficient Balance!");
                return false;
            }
            user.balance -= amount;
            balance -= amount;
            return true;
        }
        return false;
    }
    // Check balance
    void checkBalance(String accNumber) {
        if (!accountNumber.containsKey(accNumber)) {
            System.out.println("Account not found!");
            return;
        }
        System.out.println("Balance: " + accountNumber.get(accNumber).balance);
    }

    void displayAllUsers() {
        if (accountNumber.isEmpty()) {
            System.out.println("No users found in this bank.");
            return;
        }

        System.out.println("\n--- All Users in Bank: " + name + " ---");

        for (Map.Entry<String, Account> entry : accountNumber.entrySet()) {
            String accNo = entry.getKey();
            Account acc = entry.getValue();

            System.out.println("Account Number: " + accNo +
                    " | Balance: " + acc.balance);
        }
    }
}
