package sorters;

public class QuickSorter implements Sorter {
    @Override
    public int[] sort(int[] array) {
        return quickSort(array, 0, array.length-1);
    }

    public static int[] quickSort(int[] array, int first, int last) {
        if (array.length == 0) return array;

        if (first >= last) return array;

        int middle = first + (last - first) / 2;
        int support = array[middle];

        int i = first;
        int j = last;

        while (i <= j) {
            while (array[i] < support){
                i++;
            }
            while (array[j] > support){
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
            if (first < j) quickSort(array, first, j);
            if (last > i) quickSort(array, i, last);
        }
        return array;
    }

    private static void swap(int[] array, int indexOne, int indexTwo) {
        int swapped = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = swapped;
    }
}
