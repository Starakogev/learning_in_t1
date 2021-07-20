package sorters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayValueGenerator {
    static Sorter sorter = new BubbleSorter();

    public static int[] generateValues(int quantity){
        int[] values = new int[quantity];
        Random random = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(quantity);
        }
        return values;
    }

    public static int[] sortGeneratedValues(int[] values){
        int[] array = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            array[i] = values[i];
        }
        return sorter.sort(array);
    }

}
