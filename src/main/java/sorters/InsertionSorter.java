package sorters;

public class InsertionSorter implements Sorter {
    @Override
    public int[] sort(int[] array) {

        for (int left = 1; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i+1] = value;
        }

        return array;
    }
}
