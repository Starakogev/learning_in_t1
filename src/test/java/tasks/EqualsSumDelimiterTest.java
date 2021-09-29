package tasks;

import org.junit.jupiter.api.Test;
import sorters.BubbleSorter;
import sorters.Sorter;
import valueGenerators.ArrayValueGenerator;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EqualsSumDelimiterTest {
    int[] array = ArrayValueGenerator.generateValues(30);

    @Test
    void findIndex() {
        System.out.println(Arrays.toString(array));
        System.out.println(EqualsSumDelimiter.findIndex(array));
        System.out.println(EqualsSumDelimiterAlternative.findIndex(array));
    }
}