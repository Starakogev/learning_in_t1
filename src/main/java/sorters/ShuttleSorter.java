package sorters;

/**
 * Челночная сортировка
 */
public class ShuttleSorter implements Sorter {
    @Override
    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]){
                swap(array, i, i-1);
                for (int z = i-1; (z-1) >= 0; z--) {
                    if(array[z]< array[z-1]){
                        swap(array, z, z-1);
                    } else {
                        break;
                    }
                }
            }
        }
        return array;
    }

    private void swap(int[] array, int indexOne, int indexTwo) {
        int swapped = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = swapped;
    }
}
