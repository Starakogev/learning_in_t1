package sorters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import valueGenerators.ArrayValueGenerator;

import java.util.Arrays;

class BubbleSorterTest {
    Sorter sorter = new BubbleSorter();

    int[] unsortedArray = ArrayValueGenerator.generateValues(10);

    int[] sortedArray = ArrayValueGenerator.sortGeneratedValues(unsortedArray);

    @Test
    void sort() {

        System.out.println(Arrays.toString(unsortedArray));

        int[] sorted = sorter.sort(unsortedArray);

        System.out.println(Arrays.toString(unsortedArray));

        Assertions.assertArrayEquals(sortedArray, sorted);
    }
}