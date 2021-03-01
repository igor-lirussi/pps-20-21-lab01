package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount implements BankAccount {

    private double feeAtm;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance, double feeAtm) {
        super(holder, balance);
        this.feeAtm = feeAtm;
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


    private boolean isWithdrawAllowedAtm(final double amount){
        return isWithdrawAllowed(amount+feeAtm);
    }

}
