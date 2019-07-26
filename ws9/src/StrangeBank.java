import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StrangeBank {
    public static void main(String args[]) {
        LinkedHashMap<String, Double> fromAccount = new LinkedHashMap<>();
        fromAccount.put("Dollar(s)", 1.0);
        fromAccount.put("Euro(s)", 2.0);
        fromAccount.put("Pound(s)", 3.0);
        HashMap<String, Double> toAccount = new HashMap<>();
        Account sharedAccount = new Account();
        emtTo transaction = new emtTo(sharedAccount, fromAccount);
        withdrawProcess withDraw = new withdrawProcess(sharedAccount, toAccount);
        transaction.start();
        withDraw.start();


    }
}

class Account{
    private String currency;
    private Double amount;
    private boolean canDeposit = true;
    private boolean emptyBalance = true;
    public synchronized Entry<String, Double> withdrawMoney() {
        while(canDeposit) {
            try {
                System.out.println("Deposit Request");
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println( Thread.currentThread().getName()
                + " withdraw " + amount + " " + currency );

        Entry<String, Double> money = new AbstractMap.SimpleEntry<>(currency, amount);
        canDeposit = true;
        this.currency = null;
        this.amount = (double) 0;
        notify();
        return money;
    }
    public synchronized void depositMoney(String currency, double amount)  {

        while(!canDeposit) {
            try {
                System.out.println("The bank account is not empty, can not deposit!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Bank available---------> ");
        System.out.println( Thread.currentThread().getName()
                + " deposit " + amount + " " + currency);
        this.currency = currency;
        this.amount = amount;
        canDeposit = false;
        notify();
    }
    public synchronized void setBalance(boolean balanceState ) {
        this.emptyBalance = balanceState;
    }
    public boolean getBalanceState() {
        return emptyBalance;
    }
}

class emtTo extends Thread {
    private Account sharedAccount;
    private Map<String, Double> balance;
    public emtTo(Account sharedAccount, Map<String, Double> balance) {
        super("I ");
        this.sharedAccount = sharedAccount;
        this.balance = balance;

    }

    public void run() {
        while(balance.entrySet().iterator().hasNext()) {

            try {
                Thread.sleep( (int)(Math.random() * 3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String currency = balance.entrySet().iterator().next().getKey();
            Double amount = balance.entrySet().iterator().next().getValue();
            balance.remove(currency);
            sharedAccount.depositMoney(currency, amount);
        };
        sharedAccount.setBalance(false);
    }
}

class withdrawProcess extends Thread {
    private Account sharedAccount;
    private Map<String, Double> balance;
    public withdrawProcess(Account sharedAccount, Map<String, Double> balance) {
        super("Friend ");
        this.sharedAccount = sharedAccount;
        this.balance = balance;
    }
    public void run() {
        do {
            try {
                Thread.sleep( (int) ( Math.random() * 3000 ) );
            } catch(InterruptedException e) {
                System.err.println(e.toString());
            }
            Entry<String, Double> money = sharedAccount.withdrawMoney();
            balance.put(money.getKey(), money.getValue());
        } while ( sharedAccount.getBalanceState());
    }
}







