package DefinePersonClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<BankAccount> accounts = new ArrayList<>();
    private static double globalInterest;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {
            String[] inputParams = input.split(" ");
            String action = inputParams[0];
            switch (action) {
                case "Create":
                    createBankAccount();
                    break;
                case "Deposit":
                    int accountId = Integer.parseInt(inputParams[1]);
                    double amount = Double.parseDouble(inputParams[2]);
                    depositSum(accountId, amount);
                    break;
                case "SetInterest":
                    double newInterest = Double.parseDouble(inputParams[1]);
                    setGlobalInterest(newInterest);
                    break;
                case "GetInterest":
                    accountId = Integer.parseInt(inputParams[1]);
                    int years = Integer.parseInt(inputParams[2]);
                    printInterest(accountId, years);
                    break;
                default:
                    break;
            }
            input = reader.readLine();
        }
    }

    private static void printInterest(int accountId, int years) {
        boolean accountExists = false;
        for (BankAccount account : accounts) {
            if (account.getId() == accountId) {
                System.out.printf("%.2f%n", account.getInterest(years));
                accountExists = true;
                break;
            }
        }

        if (!accountExists) {
            System.out.println("Account does not exist");
        }
    }

    private static void depositSum(int id, double amount) {
        boolean successfulDeposit = false;
        for (BankAccount account : accounts) {
            if (account.getId() == id) {
                account.deposit(amount);
                DecimalFormat df = new DecimalFormat("##.##");
                System.out.println("Deposited " + df.format(amount) + " to " + account.toString());
                successfulDeposit = true;
                break;
            }
        }

        if (!successfulDeposit) {
            System.out.println("Account does not exist");
        }
    }

    private static void createBankAccount() {
        BankAccount ba = new BankAccount();
        accounts.add(ba);
        System.out.println("Account " + ba.toString() + " created");
    }

    public static void setGlobalInterest(double globalInterest) {
        BankAccount.setInterest(globalInterest);
    }
}
