package PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] pizzaTokens = reader.readLine().split(" ");
        String[] doughTokens = reader.readLine().split(" ");
        try {
            Pizza resultPizza = new Pizza(pizzaTokens[1], Integer.parseInt(pizzaTokens[2]));
            Dough dough = new Dough(doughTokens[1], doughTokens[2], Integer.parseInt(doughTokens[3]));
            resultPizza.setDough(dough);
            String line = reader.readLine();
            while (!"end".equalsIgnoreCase(line)) {
                String[] tokens = line.split(" ");
                String toppingType = tokens[1];
                int weight = Integer.parseInt(tokens[2]);
                resultPizza.addTopping(new Topping(toppingType, weight));
                line = reader.readLine();
            }
            System.out.printf("%s - %.2f", resultPizza.getName(), resultPizza.calculateCalories());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
