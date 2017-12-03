package DefinePersonClass;

public class BankAccount {
    private final static double DEFAULT_INTEREST = 0.02;

    private static double rate = DEFAULT_INTEREST;
    private static int bankAccountCount;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = ++bankAccountCount;
    }

    public static void setInterest(double interest) {
        rate = interest;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getInterest(int years) {
        return this.balance * years * rate;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {

        return balance;
    }
}
