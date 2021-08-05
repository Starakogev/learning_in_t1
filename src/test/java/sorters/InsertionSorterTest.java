package sorters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class InsertionSorterTest {
    Sorter sorter = new InsertionSorter();

    int[] unsortedArray = ArrayValueGenerator.generateValues(100000);
    int[] unsortedArray2 = ArrayValueGenerator.generateValues(500000);

    int[] sortedArray = ArrayValueGenerator.sortGeneratedValues(unsortedArray);

    @Test
    void sort() {

        System.out.println(Arrays.toString(unsortedArray));

        sorter.sort(unsortedArray);
        long startMillis = System.currentTimeMillis();
        sorter.sort(unsortedArray);
        long stopMillis = System.currentTimeMillis();

        long startMillis2 = System.currentTimeMillis();
        sorter.sort(unsortedArray2);
        long stopMillis2 = System.currentTimeMillis();

        System.out.println(Arrays.toString(unsortedArray));

        System.out.println(stopMillis - startMillis);
        System.out.println(stopMillis2 - startMillis2);

        Assertions.assertArrayEquals(sortedArray, unsortedArray);
    }
}