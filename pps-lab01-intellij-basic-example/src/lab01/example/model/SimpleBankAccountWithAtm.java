package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    private double balance;
    private final AccountHolder holder;

    private double feeAtm;


    public SimpleBankAccountWithAtm(AccountHolder holder, double balance, double feeAtm) {
        this.holder = holder;
        this.balance = balance;
        this.feeAtm = feeAtm;
    }

    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += amount;
        }
    }

    @Override
    public void withdraw(final int usrID, final double amount) {
        if (checkUser(usrID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
        }
    }

    public void depositWithAtm(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            balance += amount;
            balance -= feeAtm;
        }
    }

    public void withdrawWithAtm(final int usrID, final double amount) {
        if (checkUser(usrID) && isWithdrawAllowedAtm(amount)) {
            this.balance -= amount;
            balance -= feeAtm;
        }
    }

    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount;
    }

    private boolean isWithdrawAllowedAtm(final double amount){
        return isWithdrawAllowed(amount+feeAtm);
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
