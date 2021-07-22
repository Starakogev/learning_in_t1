package sorters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Генератор тестовых значений
 */
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
        int[] array = values.clone();
        MergeSorter.mergeSort(array, 0, array.length - 1);
        return array;
    }

}
