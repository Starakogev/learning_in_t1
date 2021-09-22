package tasks;

import org.junit.jupiter.api.Test;
import sorters.BubbleSorter;
import sorters.Sorter;
import valueGenerators.ArrayValueGenerator;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EqualsSumDelimiterTest {
    int[] array = ArrayValueGenerator.generateValues(30);

    //с этими массивом второй метод сработал не правильно
//    int[] array = {11, 0, 14, 9, 12, 1, 13, 16, 17, 5, 11, 8, 3, 2, 0, 10, 1, 4, 15};
//    int[] array = {14, 8, 6, 15, 16, 11, 10, 17, 12, 7, 11, 14, 17, 17, 6, 16, 18, 10, 8};
//    int[] array = {9, 1, 11, 0, 17, 0, 9, 16, 17, 1, 14, 3, 4, 13, 6, 13, 2, 16, 6};
//    int[] array = {6, 27, 24, 29, 1, 8, 22, 13, 26, 23, 17, 5, 15, 19, 16, 10, 28, 9, 5, 8, 4, 21, 16, 22, 20, 26, 29, 0, 22, 28};

    @Test
    void findIndex() {
        System.out.println(Arrays.toString(array));
        System.out.println(EqualsSumDelimiter.findIndex(array));
        System.out.println(EqualsSumDelimiterAlternative.findIndex(array));
    }
}