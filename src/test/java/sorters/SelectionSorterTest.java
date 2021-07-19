package sorters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSorterTest {

    Sorter sorter = new SelectionSorter();
    @Test
    void sort() {
        int[] unsortedArray = {10, 7, 4, 3, 1, 5, 9, 6, 2, 8};
        int[] sortedArray = new int[10];
        for (int i = 0; i < 10; i++) {
            sortedArray[i]=i+1;
        }
        System.out.println(Arrays.toString(sortedArray));

        sorter.sort(unsortedArray);

        System.out.println(Arrays.toString(unsortedArray));

        Assertions.assertArrayEquals(sortedArray, unsortedArray);
    }
}