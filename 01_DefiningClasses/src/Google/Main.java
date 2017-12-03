package Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Map<String, Person> persons = new HashMap<>();

        while (!"end".equalsIgnoreCase(input)) {
            String[] inputParams = input.split("\\s+");
            String personName = inputParams[0];
            persons.putIfAbsent(personName, new Person(personName));
            String itemToAdd = inputParams[1];

            switch (itemToAdd) {
                case "company":
                    String companyName = inputParams[2];
                    String department = inputParams[3];
                    double salary = Double.parseDouble(inputParams[4]);
                    setCompanyToPerson(persons, personName, companyName, department, salary);
                    break;
                case "pokemon":
                    String pokemonName = inputParams[2];
                    String pokemonType = inputParams[3];
                    addPokemonToPerson(persons, personName, pokemonName, pokemonType);
                    break;
                case "parents":
                    String parentName = inputParams[2];
                    String parentBirthday = inputParams[3];
                    addParentToPerson(persons, personName, parentName, parentBirthday);
                    break;
                case "children":
                    String childName = inputParams[2];
                    String childBirthday = inputParams[3];
                    addChildToPerson(persons, personName, childName, childBirthday);
                    break;
                case "car":
                    String carModel = inputParams[2];
                    int carPower = Integer.parseInt(inputParams[3]);
                    setCarToPerson(persons, personName, carModel, carPower);
                    break;
            }
            input = reader.readLine();
        }

        String neededPersonName = reader.readLine();
        Person neededPerson = persons.get(neededPersonName);
        Company currentCompany = neededPerson.getCompany();
        Car currentCar = neededPerson.getCar();
        List<Pokemon> currentPokemons = neededPerson.getPokemons();
        List<Parent> currentParents = neededPerson.getParents();
        List<Child> currentChildren = neededPerson.getChildren();

        System.out.println(neededPersonName);
        System.out.println("Company:");
        if (currentCompany != null) {
            System.out.println(currentCompany.toString());
        }
        System.out.println("Car:");
        if (currentCar != null) {
            System.out.println(currentCar.toString());
        }
        System.out.println("Pokemon:");
        if (currentPokemons.size() > 0){
            for (Pokemon pokemon : currentPokemons) {
                System.out.println(pokemon.toString());
            }
        }
        System.out.println("Parents:");
        if (currentParents.size() > 0) {
            for (Parent parent : currentParents) {
                System.out.println(parent.toString());
            }
        }
        System.out.println("Children:");
        if (currentChildren.size() > 0) {
            for (Child child : currentChildren) {
                System.out.println(child.toString());
            }
        }
    }

    private static void setCarToPerson(Map<String, Person> persons, String personName, String carModel, int carPower) {
        Car newCar = new Car(carModel, carPower);
        persons.get(personName).setCar(newCar);
    }

    private static void addChildToPerson(Map<String, Person> persons,
                                         String personName,
                                         String childName,
                                         String childBirthday) {
        Child newChild = new Child(childName, childBirthday);
        persons.get(personName).addChild(newChild);
    }

    private static void addParentToPerson(Map<String, Person> persons,
                                          String personName,
                                          String parentName,
                                          String parentBirthday) {
        Parent newParent = new Parent(parentName, parentBirthday);
        persons.get(personName).addParent(newParent);
    }

    private static void addPokemonToPerson(Map<String, Person> persons,
                                           String personName,
                                           String pokemonName,
                                           String pokemonType) {
        Pokemon newPokemon = new Pokemon(pokemonName, pokemonType);
        persons.get(personName).addPokemon(newPokemon);
    }

    private static void setCompanyToPerson(Map<String, Person> persons,
                                           String personName,
                                           String companyName,
                                           String department,
                                           double salary) {
        Company newCompany = new Company(companyName, department, salary);
        persons.get(personName).setCompany(newCompany);
    }
}
