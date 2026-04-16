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
}
