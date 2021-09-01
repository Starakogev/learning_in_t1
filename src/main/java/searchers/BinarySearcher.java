package searchers;

public class BinarySearcher implements Searcher {
    @Override
    public int search(int[] array, int searchedElement) {
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        int searchPosition;
        int operationsCount = 1;

        while (firstIndex <= lastIndex) {

            operationsCount++;
            searchPosition = (firstIndex + lastIndex) / 2;

            if (searchedElement < array[searchPosition]) {
                lastIndex = searchPosition - 1;
            } else if (searchedElement > array[searchPosition]) {
                firstIndex = searchPosition + 1;
            } else if (searchedElement == array[searchPosition]) {
                System.out.println(searchedElement + " is " + ++searchPosition + " element of array");
                System.out.println("It was needed " + operationsCount + " operations");

                return searchedElement;
            }
        }
        System.out.println("Element not fount. It was needed " + operationsCount + " operations");
        return 0;
    }
}


