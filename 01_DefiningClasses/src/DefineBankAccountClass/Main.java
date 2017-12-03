package DefineBankAccountClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, BankAccount> accounts = new HashMap<>();
        String input = reader.readLine();

        while (!"end".equalsIgnoreCase(input)) {
            String[] commands = input.split(" ");
            String action = commands[0];
            int accountId = Integer.parseInt(commands[1]);
            switch (action) {
                case "Create":
                    if (!accounts.containsKey(accountId)) {
                        BankAccount account = new BankAccount();
                        account.setId(accountId);
                        accounts.put(accountId, account);
                    } else {
                        System.out.println("Account already exists");
                    }
                    break;
                case "Deposit":
                    double amount = Double.parseDouble(commands[2]);
                    if (accounts.containsKey(accountId)) {
                        accounts.get(accountId).deposit(amount);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "Withdraw":
                    amount = Integer.parseInt(commands[2]);
                    if (!accounts.containsKey(accountId)) {
                        System.out.println("Account does not exist");
                    } else if (accounts.get(accountId).getBalance() < amount) {
                        System.out.println("Insufficient balance");
                    } else {
                        accounts.get(accountId).withdraw(amount);
                    }
                    break;
                case "Print":
                    if (!accounts.containsKey(accountId)) {
                        System.out.println("Account does not exist");
                    } else {
                        System.out.printf("Account %s, balance %.2f%n", accounts.get(accountId).toString(),
                                accounts.get(accountId).getBalance());
                    }
                    break;
                default:
                    break;
            }
            input = reader.readLine();
        }
    }
}
