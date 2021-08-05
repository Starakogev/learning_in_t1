package sorters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ShellsSorterTest {
    Sorter sorter = new ShellsSorter();

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