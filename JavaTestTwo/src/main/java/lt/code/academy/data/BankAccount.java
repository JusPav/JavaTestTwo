package lt.code.academy.data;

public class BankAccount {
    private String bankName;
    private String account;
    private double balance;

    public BankAccount() {
    }
    public BankAccount(String bankName, String account, double balance) {
        this.bankName = bankName;
        this.account = account;
        this.balance = balance;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "BankAccount{" +
                "bankName='" + bankName + '\'' +
                ", account='" + account + '\'' +
                ", balance=" + balance +
                '}';
    }
}
