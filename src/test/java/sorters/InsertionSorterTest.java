package sorters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSorterTest {
    Sorter sorter = new InsertionSorter();

    @Test
    void sort() {
        int[] unsortedArray = ArrayValueGenerator.generateValues(10000);

        int[] sortedArray = ArrayValueGenerator.sortGeneratedValues(unsortedArray);

        System.out.println(Arrays.toString(unsortedArray));

        sorter.sort(unsortedArray);

        System.out.println(Arrays.toString(unsortedArray));

        Assertions.assertArrayEquals(sortedArray, unsortedArray);
    }
}