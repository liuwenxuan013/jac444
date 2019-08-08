import java.io.Serializable;
public class Accounts implements Serializable{

    private static final long serialVersionUID = 1L;
    private int account;
    private String firstName;
    private String lastName;
    private double balance;
    public Accounts() {
        this(0, "", "", 0.0);
    }


    public Accounts(int account, String firstName, String lastName, double balance) {
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public int getAccount() {
        return account;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public double getBalance() {
        return balance;
    }
}