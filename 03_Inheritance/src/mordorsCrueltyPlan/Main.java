package mordorsCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> foods = Arrays.asList(reader.readLine().split(" "));
        Gandalf gandalf = new Gandalf();

        for (String food : foods) {
            gandalf.eatFood(food);
        }

        System.out.println(gandalf.getHappinessIndex());
        System.out.println(gandalf.getMood());
    }
}
