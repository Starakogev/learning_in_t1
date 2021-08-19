package sorters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import valueGenerators.ArrayValueGenerator;

import java.util.Arrays;

class PyramidalSorterTest {
    Sorter sorter = new PyramidalSorter();

    int[] unsortedArray = ArrayValueGenerator.generateValues(100);

    int[] sortedArray = ArrayValueGenerator.sortGeneratedValues(unsortedArray);

    @Test
    void sort() {
        System.out.println(Arrays.toString(unsortedArray));

        sorter.sort(unsortedArray);

        System.out.println(Arrays.toString(unsortedArray));

        Assertions.assertArrayEquals(sortedArray, unsortedArray);
    }
}