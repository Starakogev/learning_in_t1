package tasks;

public class EqualsSumDelimiterAlternative {
    public static int findIndex(int[] array) {
        int arraySum = 0;
        for (int value : array) {
            arraySum += value;
        }
        int leftArraySum = 0;
        int iterator = 0;
        while (leftArraySum <= arraySum - (leftArraySum + array[iterator])) {
            leftArraySum += array[iterator];
            iterator++;
        }
        int rightArraySumOne = arraySum - (leftArraySum + array[iterator]);
        int rightArraySumTwo = arraySum - (leftArraySum);
        if (Math.abs(leftArraySum - rightArraySumOne) >= Math.abs(rightArraySumTwo - (leftArraySum - array[iterator - 1]))) {
            iterator--;
        }
        return iterator;
    }
}
