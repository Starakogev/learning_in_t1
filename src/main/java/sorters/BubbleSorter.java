package sorters;

//добавить сдвигающиея границы итарации
public class BubbleSorter implements Sorter {
    @Override
    public int[] sort(int[] array) {
        boolean needIteration = true;
        int counter = 0;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < array.length-(counter); i++) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    needIteration = true;
                }
            }
            counter++;
        }
        return array;
    }

    private void swap(int[] array, int indexOne, int indexTwo) {
        int swapped = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = swapped;
    }
}
