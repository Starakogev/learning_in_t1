package collections.list.array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomArrayListTest {
    List<Integer> customArrayList = new CustomArrayList<>();

    public List<Integer> getCustomArrayList() {
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
        return customArrayList;
    }

    @Test
    void addLast() {
        //test
        customArrayList.add(13);

        //check
        assertEquals(13, customArrayList.get(0));
    }

    @Test
    void addLastToIndex() {
        List<Integer> customArrayList = getCustomArrayList();

        //test
        customArrayList.add(3, 14);

        //check
        assertEquals(14, customArrayList.get(3));
    }

    @Test
    void removeToIndex() {
        List<Integer> customArrayList = getCustomArrayList();

        //test
        Integer remove = customArrayList.remove(3);

        //check
        assertEquals(4, customArrayList.get(3));
        assertEquals(3, remove);
    }

    @Test
    void removeValue() {
        List<String> customArrayList = new CustomArrayList<>();
        customArrayList.add("Привет");
        customArrayList.add("Пока");
        customArrayList.add("Привет");

        //test
        boolean remove = customArrayList.remove("Привет");

        //check
        assertEquals("Пока", customArrayList.get(0));
        assertTrue(remove);
    }

    @Test
    void contain() {
        List<String> customArrayList = new CustomArrayList<>();
        customArrayList.add("Привет");
        customArrayList.add("Пока");
        customArrayList.add("Привет");

        assertTrue(customArrayList.contains("Пока"));
        assertFalse(customArrayList.contains("Fuf"));
    }

    @Test
    void exception() {
        List<Integer> customArrayList = getCustomArrayList();

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            customArrayList.get(customArrayList.size());
        });
    }
}