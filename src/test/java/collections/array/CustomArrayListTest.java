package collections.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {
    CustomArrayList customArrayList = new CustomArrayList();
    Object[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Test
    void addLast() {
        customArrayList.add(0);
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(4);
        customArrayList.add(5);
        customArrayList.add(6);
        customArrayList.add(7);
        customArrayList.add(8);
        customArrayList.add(9);
        customArrayList.add(10);
        customArrayList.add(11);
        customArrayList.add(12);
        customArrayList.add(13);
        System.out.println(Arrays.toString(customArrayList.array));
    }

    @Test
    void addLastToIndex() {
        customArrayList.add(0);
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(4);
        customArrayList.add(5);
        customArrayList.add(6);
        customArrayList.add(7);
        customArrayList.add(8);
        customArrayList.add(9);

        customArrayList.add(3, 14);
        customArrayList.add(3, 14);
        customArrayList.add(7, 14);
        customArrayList.add(10, 14);
        System.out.println(Arrays.toString(customArrayList.array));
        System.out.println(customArrayList.size());
    }

    @Test
    void removeToIndex() {
        customArrayList.add(0);
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(4);
        customArrayList.add(5);
        customArrayList.add(6);
        customArrayList.add(7);
        customArrayList.add(8);
        customArrayList.add(9);
        customArrayList.add(10);
        customArrayList.add(11);
        customArrayList.add(12);
        customArrayList.add(13);

        customArrayList.remove(3);
        System.out.println(Arrays.toString(customArrayList.array));
        System.out.println(customArrayList.size());
    }
}