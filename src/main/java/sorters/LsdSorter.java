package sorters;

public class LsdSorter implements Sorter {
    @Override
    public int[] sort(int[] array) {
        int maxRank = findMaxRank(array);
        int divider = 1;

        for (int i = 0; i < maxRank; i++) {
            array = finalSort(array, divider);
            divider *= 10;
        }

        return array;
    }

    public int findMaxRank(int[] array) {
        int maxRank = 1;

        for (int value : array) {
            int rank = spotRank(value);
            if (rank > maxRank) {
                maxRank = rank;
            }
        }

        return maxRank;
    }

    public int spotRank(int arrayValue) {
        int rank = 1;
        long stage = 10;

        while (arrayValue >= stage) {
            rank++;
            stage *= 10;
        }

        return rank;
    }

    public int[] finalSort(int[] array, int divider) {
        int[] keys = getMinMaxKey(array, divider);
        int minKey = keys[0];
        int maxKey = keys[1];
        int lengthOfSupportArray = maxKey - minKey + 1;
        int[] supportArray = new int[lengthOfSupportArray];

        for (int value : array) {
            supportArray[getRank(value, divider) - minKey] += 1;
        }

        int size = array.length;

        for (int i = supportArray.length - 1; i >= 0; i--) {
            size -= supportArray[i];
            supportArray[i] = size;
        }

        int[] sortedArray = new int[array.length];

        for (int value : array) {
            int CurrentIndex = getRank(value, divider) - minKey;
            sortedArray[supportArray[CurrentIndex]] = value;
            supportArray[CurrentIndex] += 1;
        }

        return sortedArray;
    }

    public int[] getMinMaxKey(int[] array, int divider) {
        int minKey = getRank(array[0], divider);
        int maxKey = minKey;

        for (int number : array) {
            int rank = getRank(number, divider);
            if (rank < minKey) {
                minKey = rank;
            }
            if (rank > maxKey) {
                maxKey = rank;
            }
        }

        return new int[]{minKey, maxKey};
    }

    public int getRank(int number, int divider) {
        return number % (divider * 10) / (divider);
    }
}
