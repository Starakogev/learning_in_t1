package collections.hashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {


    private final HashMap<Integer, String> testCustomMap = new HashMap<>();
    private final String testValue = "value";
    private final Integer testKey = 1;

    @Test
    void putNewValueToEmptyBucket() {
        String value = "123";
        testCustomMap.put(1, value);
        Object received = testCustomMap.get(1);
        assertEquals(value, received);
    }

    @Test
    void putTwoValuesWithDifferentKeysToOneBucket() {
        String value1 = "123";
        String value2 = "456";
        testCustomMap.put(1, value1);
        testCustomMap.put(11, value2);
        assertEquals(value1, testCustomMap.get(1));
        assertEquals(value2, testCustomMap.get(11));
    }

    @Test
    void putTwoValuesWithEqualsKeysShouldBeRewritten() {
        String value1 = "123";
        String value2 = "456";
        testCustomMap.put(1, value1);
        assertEquals(value1, testCustomMap.get(1));
        testCustomMap.put(1, value2);
        assertEquals(value2, testCustomMap.get(1));
    }

    @Test
    void putTwoValuesWithEqualsFirstValueShouldBeRewritten() {
        String value1 = "123";
        String value2 = "456";
        testCustomMap.put(1, value1);
        testCustomMap.put(1, value2);
        assertEquals(value2, testCustomMap.get(1));
    }


    @Test
    void sizeForNewMapShouldBeZero() {
        assertEquals(0, testCustomMap.size());
    }


    @Test
    void sizeForNewMapShouldNotBeEmpty() {
        String value1 = "value";
        testCustomMap.put(1, value1);
        assertEquals(1, testCustomMap.size());
    }

    @Test
    void sizeForRemovableItemMapShouldNotBeChanged() {
        String value1 = "value";
        testCustomMap.put(1, value1);
        testCustomMap.remove(2);
        assertEquals(1, testCustomMap.size());
    }

    @Test
    void sizeForRemovableItemMapShouldBeDecremented() {
        String value1 = "value";
        String value2 = "Doublevalue";
        testCustomMap.put(1, value1);
        testCustomMap.put(2, value2);
        testCustomMap.remove(1);
        assertEquals(1, testCustomMap.size());
    }

    @Test
    void reWritingValueDoesntChangeSize() {
        String value1 = "value";
        String value2 = "Doublevalue";
        testCustomMap.put(1, value1);
        int expectedSize = testCustomMap.size();
        testCustomMap.put(1, value2);
        assertEquals(expectedSize, testCustomMap.size());
    }

    @Test
    void removeExistingItemFromHashMap() {
        String value1 = "value";
        testCustomMap.put(1, value1);
        testCustomMap.remove(1);
        Assertions.assertNull(testCustomMap.get(1));
    }

    @Test
    void removeExistingItemFromHashMapToReturnOldValue() {
        String value1 = "value";
        testCustomMap.put(1, value1);
        Object removeReturned = testCustomMap.remove(1);
        assertEquals(value1, removeReturned);
    }

    @Test
    void removeExistingItemFromHashMapFromMidle() {
        String value1 = "value";
        String value2 = "Doublevalue";
        String value3 = "Triplevalue";
        testCustomMap.put(1, value1);
        testCustomMap.put(11, value2);
        testCustomMap.put(21, value3);
        testCustomMap.remove(11);
        Assertions.assertNull(testCustomMap.get(11));
        assertEquals(value1, testCustomMap.get(1));
        assertEquals(value3, testCustomMap.get(21));
    }

    @Test
    void removeNotExistingItemFromHash() {
        Object removeReturned = testCustomMap.remove(1);
        Assertions.assertNull(removeReturned);
    }

    @Test
    void putMillionElements() {
        int size = 1000000;
        String[] testDate = new String[size];
        for (int i = 0; i < size; i++) {
            testDate[i] = "i" + i;
            testCustomMap.put(i, testDate[i]);
        }
        for (int i = 0; i < size; i++) {
            assertEquals(testDate[i], testCustomMap.get(i));
        }
        assertEquals(size, testCustomMap.size());
    }

    @Test
    void removeMillionElements() {
        int size = 1000000;
        String[] testDate = new String[size];
        for (int i = 0; i < size; i++) {
            testDate[i] = "i" + i;
            testCustomMap.put(i, testDate[i]);
        }

        for (int i = 0; i < size; i++) {
            testCustomMap.remove(i);
            Assertions.assertNull(testCustomMap.get(i));
        }

        assertEquals(0, testCustomMap.size());
    }

    @Test
    void customKeyAsKeyUsage() {
        int size = 1000;
        HashMap<CustomKey, String> testMap = new HashMap<>();
        Map<CustomKey, String> actualMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            //CustomKey testKey = new CustomKey(i, "i"+i, "i"+i);
            String value = "i" + i;
            testMap.put(new CustomKey(i, "i" + i, "i" + i), value);
            actualMap.put(new CustomKey(i, "i" + i, "i" + i), value);
        }
        System.out.println();
        for (Map.Entry<CustomKey, String> currentEntry : actualMap.entrySet()) {
            Assertions.assertEquals(actualMap.get(currentEntry.getKey()), testMap.get(currentEntry.getKey()));
        }
        Assertions.assertEquals(size, testMap.size());
    }

    @Test
    void KeyUsageString() {
        int size = 1000;
        HashMap<String, Integer> testMap = new HashMap<>();
        Map<String, Integer> actualMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            testMap.put("i" + i, i);
            actualMap.put(new String("i" + i), i);
        }
        System.out.println();
        for (Map.Entry<String, Integer> currentEntry : actualMap.entrySet()) {
            Assertions.assertEquals(actualMap.get(currentEntry.getKey()), testMap.get(currentEntry.getKey()));
        }
    }

    @Test
    void putAndGetNullKeyElement() {
        String value = "value";
        testCustomMap.put(null, value);
        Assertions.assertEquals(value, testCustomMap.get(null));
    }

    @Test
    void removeNullKeyElement() {
        String value1 = "value";
        testCustomMap.put(null, value1);
        Object removeReturned = testCustomMap.remove(null);
        assertEquals(value1, removeReturned);
    }

    @Test
    void rewriteNullKeyElement() {
        String oldValue = "value";
        String secondValue = "Secondvalue";
        String thirdValue = "Thirdvalue";
        String fourthValue = "fourthvalue";
        String fifthValue = "fifthvalue";
        testCustomMap.put(null, oldValue);
        testCustomMap.put(null, secondValue);
        testCustomMap.put(null, thirdValue);
        testCustomMap.put(null, fourthValue);
        testCustomMap.put(null, fifthValue);
        Assertions.assertEquals(fifthValue, testCustomMap.get(null));
        Assertions.assertEquals(1, testCustomMap.size());
    }

    @Test
    void testContainKeyAndContainValueMethods() {
        testCustomMap.put(1, testValue);
        Assertions.assertTrue(testCustomMap.containsKey(1));
        Assertions.assertFalse(testCustomMap.containsKey(2));
        Assertions.assertTrue(testCustomMap.containsValue("value"));
        Assertions.assertFalse(testCustomMap.containsValue("Fuck"));
    }

    @Test
    void testContainKeyAndContainValueMethodsForNullPointer() {
        testCustomMap.put(null, testValue);
        Assertions.assertTrue(testCustomMap.containsKey(null));
        Assertions.assertFalse(testCustomMap.containsKey(2));
        Assertions.assertTrue(testCustomMap.containsValue("value"));
        Assertions.assertFalse(testCustomMap.containsValue("Fuck"));
    }

}