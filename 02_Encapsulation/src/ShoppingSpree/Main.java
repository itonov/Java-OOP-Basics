package ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputPeople = reader.readLine().split(";");
        String[] inputProducts = reader.readLine().split(";");
        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        try {
            for (String person : inputPeople) {
                String name = person.split("=")[0];
                double money = Double.parseDouble(person.split("=")[1]);

                Person newPerson = new Person(name, money);
                people.add(newPerson);

            }

            for (String product : inputProducts) {
                String name = product.split("=")[0];
                double money = Double.parseDouble(product.split("=")[1]);
                Product newProduct = new Product(name, money);
                products.add(newProduct);
            }

            String inputAction = reader.readLine();
            while (!"end".equalsIgnoreCase(inputAction)) {
                String[] tokens = inputAction.split("\\s+");
                String personName = tokens[0];
                String productName = tokens[1];
                Person currentPerson = null;
                Product currentProduct = null;

                for (Person person : people) {
                    if (person.getName().equals(personName)) {
                        currentPerson = person;
                        break;
                    }
                }

                for (Product product : products) {
                    if (product.getName().equals(productName)) {
                        currentProduct = product;
                        break;
                    }
                }

                if (currentPerson.getMoney() < currentProduct.getCost()) {
                    System.out.printf("%s can't afford %s%n", currentPerson.getName(), currentProduct.getName());
                } else {
                    currentPerson.addProduct(currentProduct);
                    currentPerson.setMoney(currentPerson.getMoney() - currentProduct.getCost());
                    System.out.println(currentPerson.getName() + " bought " + currentProduct.getName());
                }
                inputAction = reader.readLine();
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        for (Person person : people) {
            List<Product> currentBag = person.getBagOfProducts();
            if (currentBag.size() == 0) {
                System.out.println(person.getName() + " - Nothing bought");
            } else {
                System.out.println(person.getName() + " - " + currentBag.toString().replaceAll("[\\[\\]]", ""));
            }
        }
    }
}
