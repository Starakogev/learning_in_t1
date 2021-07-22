package sorters;

/**
 * Сортировка слиянием
 */
public class MergeSorter implements Sorter {
    @Override
    public int[] sort(int[] array) {
        return array;
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int middle = (left + right) / 2;
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        merge(array, left, middle, right);
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int lengthLeft = middle - left + 1;
        int lengthRight = right - middle;
        int[] leftArray = new int[lengthLeft];
        int[] rightArray = new int[lengthRight];
        System.arraycopy(array, left, leftArray, 0, lengthLeft);
        for (int i = 0; i < lengthRight; i++) {
            rightArray[i] = array[middle + i + 1];
        }
        int leftIndex = 0;
        int rightIndex = 0;
        //почему i идет от left до right+1
        for (int i = left; i < right + 1; i++) {
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}
