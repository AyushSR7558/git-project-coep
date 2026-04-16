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
}