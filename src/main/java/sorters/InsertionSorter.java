package sorters;

/**
 * Сортировка вставкой
 */
public class InsertionSorter implements Sorter {
    @Override
    public int[] sort(int[] array) {

        for (int left = 1; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            while (i >= 0 && value < array[i]) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = value;
        }
        return array;
    }
}
