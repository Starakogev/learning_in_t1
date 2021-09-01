package sorters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import valueGenerators.ArrayValueGenerator;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LsdSorterTest {
    Sorter sorter = new LsdSorter();

    int[] unsortedArray = {5, 23, 3, 44, 132, 18, 324, 1000};

    int[] sortedArray = ArrayValueGenerator.sortGeneratedValues(unsortedArray);

    @Test
    void sort() {
        System.out.println(Arrays.toString(unsortedArray));

        int[] sorted = sorter.sort(unsortedArray);

        System.out.println(Arrays.toString(sorted));

        Assertions.assertArrayEquals(sortedArray, sorted);
    }
}