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

    public void pyramidCreation(int[] array, int length, int startIndexing) {
        int leftChildIndex = 2 * startIndexing + 1;
        int rightChildIndex = 2 * startIndexing + 2;
        int largestIndex = startIndexing;

        if (leftChildIndex < length && array[leftChildIndex] > array[largestIndex]) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < length && array[rightChildIndex] > array[largestIndex]) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != startIndexing) {
            int temp = array[startIndexing];
            array[startIndexing] = array[largestIndex];
            array[largestIndex] = temp;
            pyramidCreation(array, length, largestIndex);
        }
    }
}
