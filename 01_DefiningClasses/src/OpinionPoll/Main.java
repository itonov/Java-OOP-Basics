package OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int personCount = Integer.parseInt(reader.readLine());
        Map<String, Person> persons = new TreeMap<>();

        for (int i = 0; i < personCount; i++) {
            String[] inputParams = reader.readLine().split(" ");
            String name = inputParams[0];
            int age = Integer.parseInt(inputParams[1]);
            persons.put(name, new Person(name, age));
        }

        for (Map.Entry<String, Person> person : persons.entrySet()) {
            if (person.getValue().getAge() > 30) {
                System.out.println(person.getKey() + " - " + person.getValue().getAge());
            }
        }
    }
}
