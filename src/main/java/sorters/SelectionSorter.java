package sorters;

public class SelectionSorter implements Sorter{

    @Override
    public void sort(int[] array) {
        for (int left = 0; left < array.length; left++) {
            int minIndex = left;
            for (int i = left+1; i < array.length; i++) {
                if(array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            swap(array, left, minIndex);
        }
    }

    private void swap(int[] array, int indexOne, int indexTwo){
        int swapped = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = swapped;
    }
}
