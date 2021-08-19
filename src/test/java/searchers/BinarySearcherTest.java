package searchers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import valueGenerators.ArrayValueGenerator;

import java.util.Arrays;
import java.util.Random;

class BinarySearcherTest {

    Searcher searcher = new BinarySearcher();

    @Test
    void search() {
        int[] unsortedArray = ArrayValueGenerator.generateValues(50);

        unsortedArray[new Random().nextInt(unsortedArray.length-1)] = 13;

        int[] sortedArray = ArrayValueGenerator.sortGeneratedValues(unsortedArray);

        System.out.println(Arrays.toString(sortedArray));

        int search = searcher.search(sortedArray, 13);

        Assertions.assertEquals(13, search);
    }
}