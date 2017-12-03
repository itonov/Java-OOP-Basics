package randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<Object> extends ArrayList {
    private Random rnd;

    public Object getRandomElement() {
        int index = rnd.nextInt(super.size() - 1);
        return (Object) super.remove(index);
    }
}
