public class Account {
    private final String password;
    Integer balance;

    Account(String password){
        this.password = password;
        balance = 0;
    }

    String getPassword() {
        return password;
    }
}

