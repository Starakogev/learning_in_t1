package sorters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import valueGenerators.ArrayValueGenerator;

import java.util.Arrays;

class ShuttleSorterTest {
    Sorter sorter = new ShuttleSorter();

    int[] unsortedArray = ArrayValueGenerator.generateValues(100000);

    int[] sortedArray = ArrayValueGenerator.sortGeneratedValues(unsortedArray);

    @Test
    void sort() {

        System.out.println(Arrays.toString(unsortedArray));

        sorter.sort(unsortedArray);

        System.out.println(Arrays.toString(unsortedArray));

        Assertions.assertArrayEquals(sortedArray, unsortedArray);
    }
}