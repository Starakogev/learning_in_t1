package sorters;

public class PyramidalSorter implements Sorter {
    @Override
    public int[] sort(int[] array) {
        if (array.length == 0) {
            return null;
        }

        int length = array.length;

        for (int i = array.length / 2 - 1; i >= 0; i--) {
            pyramidCreation(array, length, i);
        }

        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            pyramidCreation(array, i, 0);
        }
        return array;
    }

    public static void pyramidCreation(int[] array, int length, int startIndexing) {
        int leftChild = 2 * startIndexing + 1;
        int rightChild = 2 * startIndexing + 2;
        int largest = startIndexing;

        if (leftChild < length && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        if (rightChild < length && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        if (largest != startIndexing) {
            int temp = array[startIndexing];
            array[startIndexing] = array[largest];
            array[largest] = temp;
            pyramidCreation(array, length, largest);
        }
    }
}
