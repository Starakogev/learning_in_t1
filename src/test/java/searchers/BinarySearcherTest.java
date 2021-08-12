package searchers;

import org.junit.jupiter.api.Test;
import sorters.ArrayValueGenerator;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearcherTest {

    Searcher searcher = new BinarySearcher();

    int[] unsortedArray = ArrayValueGenerator.generateValues(1000);

    int[] sortedArray = ArrayValueGenerator.sortGeneratedValues(unsortedArray);

    @Test
    void search() {
        System.out.println(Arrays.toString(sortedArray));

        searcher.search(sortedArray, 0, sortedArray.length - 1, 500);
    }
}