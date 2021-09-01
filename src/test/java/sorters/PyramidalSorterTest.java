package sorters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import valueGenerators.ArrayValueGenerator;

import java.util.Arrays;

class PyramidalSorterTest {
    Sorter sorter = new PyramidalSorter();

    @Test
    void sort() {
        int[] unsortedArray = {3, 5, 4, 8, 2, 3, 1};
        int[] sortedArray = ArrayValueGenerator.sortGeneratedValues(unsortedArray);

        System.out.println(Arrays.toString(unsortedArray));

        sorter.sort(unsortedArray);

        System.out.println(Arrays.toString(unsortedArray));

        Assertions.assertArrayEquals(sortedArray, unsortedArray);
    }
}