package collections.list.linked;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomLinkedListTest {
    List<Integer> integerList = new CustomLinkedList<>();
    List<String> stringList = new CustomLinkedList<>();

    public List<Integer> getIntegerList() {
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(7);
        integerList.add(8);
        integerList.add(9);
        return integerList;
    }

    public List<String> getStringList() {
        stringList.add("0");
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        stringList.add("6");
        stringList.add("7");
        stringList.add("8");
        stringList.add("9");
        return stringList;
    }

    @Test
    void size() {
        List<Integer> customList = getIntegerList();

        assertEquals(10, customList.size());
    }

    @Test
    void isEmpty() {
        List<String> stringList = getStringList();

        assertFalse(stringList.isEmpty());

        List<Integer> customList = new CustomLinkedList<>();

        assertTrue(customList.isEmpty());
    }

    @Test
    void contains() {
        List<String> stringList = getStringList();

        assertTrue(stringList.contains("2"));
        assertFalse(stringList.contains("11"));
    }

    @Test
    void iterator() {
    }

    @Test
    void toArray() {
        List<Integer> integerList = getIntegerList();

        Object[] objects = integerList.toArray();

        System.out.println(Arrays.toString(objects));

        Object[] objectsExpected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        assertEquals(Arrays.toString(objects), Arrays.toString(objectsExpected));
    }

    @Test
    void add() {
        List<Integer> customList = new CustomLinkedList<>();

        customList.add(1);

        assertEquals(1, customList.get(0));
    }

    @Test
    void removeByIndex() {
        List<Integer> customList = getIntegerList();

        customList.remove(0);

        System.out.println(customList.get(0));
        System.out.println(customList.get(1));
        System.out.println(customList.get(2));
        System.out.println(customList.get(3));
        System.out.println(customList.get(4));
        System.out.println(customList.get(5));
        System.out.println(customList.get(6));
        System.out.println(customList.get(7));
        System.out.println(customList.get(8));

        assertEquals(1, customList.get(0));
        assertEquals(9, customList.size());
    }

    @Test
    void addAll() {
        List<Integer> customList = getIntegerList();
        customList.addAll(List.of(1, 2, 5));

        System.out.println(customList.get(0));
        System.out.println(customList.get(1));
        System.out.println(customList.get(2));
        System.out.println(customList.get(3));
        System.out.println(customList.get(4));
        System.out.println(customList.get(5));
        System.out.println(customList.get(6));
        System.out.println(customList.get(7));
        System.out.println(customList.get(8));
        System.out.println(customList.get(9));
        System.out.println(customList.get(10));
        System.out.println(customList.get(11));
        System.out.println(customList.get(12));

        assertEquals(1, customList.get(10));
        assertEquals(13, customList.size());
    }

    @Test
    void addAllByIndex() {
        List<Integer> customList = getIntegerList();
        customList.addAll(3, List.of(1, 2, 5));

        System.out.println(customList.get(0));
        System.out.println(customList.get(1));
        System.out.println(customList.get(2));
        System.out.println(customList.get(3));
        System.out.println(customList.get(4));
        System.out.println(customList.get(5));
        System.out.println(customList.get(6));
        System.out.println(customList.get(7));
        System.out.println(customList.get(8));
        System.out.println(customList.get(9));
        System.out.println(customList.get(10));
        System.out.println(customList.get(11));
        System.out.println(customList.get(12));

        assertEquals(1, customList.get(3));
        assertEquals(13, customList.size());
    }

    @Test
    void clear() {
        List<Integer> integerList = getIntegerList();
        integerList.clear();

        assertEquals(0, integerList.size());
    }

    @Test
    void get() {
        List<Integer> customList = getIntegerList();

        assertEquals(0, customList.get(0));
        assertEquals(1, customList.get(1));
        assertEquals(2, customList.get(2));
        assertEquals(3, customList.get(3));
        assertEquals(4, customList.get(4));
        assertEquals(5, customList.get(5));
        assertEquals(6, customList.get(6));
        assertEquals(7, customList.get(7));
        assertEquals(8, customList.get(8));
        assertEquals(9, customList.get(9));
    }

    @Test
    void set() {
        List<Integer> customList = getIntegerList();

        customList.set(3, 7);

        assertEquals(7, customList.get(3));
        assertEquals(10, customList.size());
    }

    @Test
    void addToIndex() {
        List<Integer> customList = getIntegerList();

        customList.add(0, 7);

        System.out.println(customList.get(0));
        System.out.println(customList.get(1));
        System.out.println(customList.get(2));
        System.out.println(customList.get(3));
        System.out.println(customList.get(4));
        System.out.println(customList.get(5));
        System.out.println(customList.get(6));
        System.out.println(customList.get(7));
        System.out.println(customList.get(8));
        System.out.println(customList.get(9));
        System.out.println(customList.get(10));

        assertEquals(7, customList.get(0));
        assertEquals(0, customList.get(1));
        assertEquals(11, customList.size());
    }

    @Test
    void removeObject() {
        List<String> stringList = new CustomLinkedList<>();

        stringList.add("First");
        stringList.add("Second");
        stringList.add("Third");

        System.out.println(stringList.get(0));
        System.out.println(stringList.get(1));
        System.out.println(stringList.get(2));

        assertEquals("First", stringList.get(0));
        assertEquals("Second", stringList.get(1));
        assertEquals("Third", stringList.get(2));
        assertEquals(3, stringList.size());

        stringList.remove("Second");

        System.out.println(stringList.get(0));
        System.out.println(stringList.get(1));

        assertEquals("First", stringList.get(0));
        assertEquals("Third", stringList.get(1));
        assertEquals(2, stringList.size());
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void listIterator() {
    }

    @Test
    void testListIterator() {
    }

    @Test
    void subList() {
    }

    @Test
    void retainAll() {
        getStringList();
        stringList.retainAll(List.of("1", "2", "5", "6"));

        System.out.println(stringList.get(0));
        System.out.println(stringList.get(1));
        System.out.println(stringList.get(2));
        System.out.println(stringList.get(3));

        assertEquals("1", stringList.get(0));
        assertEquals(4, stringList.size());
    }

    @Test
    void removeAll() {
        List<Integer> customList = getIntegerList();
        customList.removeAll(List.of(1, 2, 5));

        System.out.println(customList.get(0));
        System.out.println(customList.get(1));
        System.out.println(customList.get(2));
        System.out.println(customList.get(3));
        System.out.println(customList.get(4));
        System.out.println(customList.get(5));
        System.out.println(customList.get(6));

        assertEquals(3, customList.get(1));
        assertEquals(7, customList.size());
    }

    @Test
    void containsAll() {
        List<String> stringList = getStringList();

        assertTrue(stringList.containsAll(List.of("2", "5", "7")));
        assertFalse(stringList.containsAll(List.of("2", "5", "17")));
    }

    @Test
    void testToArray() {
    }
}