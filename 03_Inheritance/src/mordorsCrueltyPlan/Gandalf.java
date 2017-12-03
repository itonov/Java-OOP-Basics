package mordorsCrueltyPlan;

import java.util.HashMap;
import java.util.Map;

public class Gandalf {
    private static final Map<String, Integer> FOODS = new HashMap<String, Integer>() {{
       put("cram", 2);
       put("lembas", 3);
       put("apple", 1);
       put("melon", 1);
       put("honeycake", 5);
       put("mushrooms", -10);
    }};

    private int happinessIndex;

    public void eatFood(String food) {
        if (FOODS.containsKey(food.toLowerCase())) {
            happinessIndex += FOODS.get(food.toLowerCase());
        } else {
            happinessIndex--;
        }
    }

    public String getMood() {
        if (this.happinessIndex < -5) {
            return "Angry";
        } else if (this.happinessIndex < 0) {
            return "Sad";
        } else if (this.happinessIndex < 15) {
            return "Happy";
        } else {
            return "JavaScript";
        }
    }

    public int getHappinessIndex() {
        return this.happinessIndex;
    }
}
