package sorters;

/**
 * Сортировка Шелла
 */
public class ShellsSorter implements Sorter {
    @Override
    public int[] sort(int[] array) {
        int interval = array.length / 2;
        while (interval >= 1) {
            for (int right = 0; right < array.length; right++) {
                for (int center = right - interval; center >= 0; center -= interval) {
                    if (array[center] > array[center + interval]) {
                        swap(array, center, center + interval);
                    }
                }
            }
            interval = interval / 2;
        }
        return array;
    }
//    5 6 7 9 2 4
    private void swap(int[] array, int indexOne, int indexTwo) {
        int swapped = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = swapped;
    }
}
