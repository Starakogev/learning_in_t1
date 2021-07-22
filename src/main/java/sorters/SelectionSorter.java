package sorters;

/**
 * Сортировка выбором
 */
public class SelectionSorter implements Sorter{

    @Override
    public int[] sort(int[] array) {
        for (int left = 0; left < array.length; left++) {
            int minIndex = left;
            for (int i = left+1; i < array.length; i++) {
                if(array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            swap(array, left, minIndex);
        }
        return array;
    }

    private void swap(int[] array, int indexOne, int indexTwo){
        int swapped = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = swapped;
    }
}
