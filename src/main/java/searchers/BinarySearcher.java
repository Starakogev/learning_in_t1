package searchers;

public class BinarySearcher implements Searcher {
    @Override
    public void search(int[] array, int firstIndex, int lastIndex, int searchedElement) {
        int searchPosition;
        int operationsCount = 1;

        searchPosition = (firstIndex + lastIndex) / 2;

        while ((array[searchPosition] != searchedElement) && (firstIndex <= lastIndex)) {
            operationsCount++;
            if (array[searchPosition] > searchedElement) {
                lastIndex = searchPosition - 1;
            } else {
                firstIndex = searchPosition + 1;
            }
            searchPosition = (firstIndex + lastIndex) / 2;
        }
        if (firstIndex <= lastIndex) {
            System.out.println(searchedElement + " is " + ++searchPosition + " element of array");
            System.out.println("It was needed " + operationsCount + " operations");
        } else {
            System.out.println("Element not fount. It was needed " + operationsCount + " operations");
        }
    }
}


