package tasks;

public class EqualsSumDelimiter {
    public static int findIndex(int[] array) {
        int delimiter = array.length / 2;
        int leftArraySum = arrayLeftSum(array, delimiter);
        int rightArraySum = arrayRightSum(array, delimiter);
        if (leftArraySum == rightArraySum) {
            return delimiter;
        }
        int differenceOne = 0;
        int differenceTwo = 0;
        if (leftArraySum < rightArraySum) {
            while (leftArraySum < rightArraySum) {
                delimiter++;
                differenceOne = rightArraySum - leftArraySum;
                leftArraySum = arrayLeftSum(array, delimiter);
                rightArraySum = arrayRightSum(array, delimiter);
            }
            if (leftArraySum > rightArraySum) {
                differenceTwo = leftArraySum - rightArraySum;
            }
            if(differenceOne < differenceTwo) {
                delimiter--;
            }
        } else {
            while (leftArraySum > rightArraySum) {
                delimiter--;
                differenceOne = leftArraySum - rightArraySum;
                leftArraySum = arrayLeftSum(array, delimiter);
                rightArraySum = arrayRightSum(array, delimiter);
            }
            if (leftArraySum < rightArraySum) {
                differenceTwo = rightArraySum - leftArraySum;
            }
            if(differenceOne < differenceTwo) {
                delimiter++;
            }
        }

        return delimiter;
    }

    private static int arrayLeftSum(int[] array, int delimiter) {
        int sum = 0;
        for (int i = 0; i < delimiter; i++) {
            sum += array[i];
        }

        return sum;
    }

    private static int arrayRightSum(int[] array, int delimiter) {
        int sum = 0;
        for (int i = delimiter + 1; i < array.length; i++) {
            sum += array[i];
        }

        return sum;
    }
}
