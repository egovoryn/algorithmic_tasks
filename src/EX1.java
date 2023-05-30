import java.util.*;

public class EX1 {
    public static void main(String[] args) {
        int size = 10;
        Integer[] array = GenerateArray.generateArray(size);
        System.out.println("Source array: " + Arrays.toString(array));
        sortArray(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    private static void sortArray(Integer[] array) {
        Stack<Integer> oddNumbers = new Stack<>();
        Stack<Integer> otherNumbers = new Stack<>();
        Stack<Integer> zeroNumbers = new Stack<>();

        for (Integer number : array) {
            if (number % 2 != 0) {
                oddNumbers.add(number);
            } else if (number == 0) {
                zeroNumbers.add(number);
            } else {
                otherNumbers.add(number);
            }
        }

        Collections.sort(otherNumbers);
        oddNumbers.sort(Comparator.reverseOrder());

        for (int i = 0; i < array.length; i++) {
            if (!oddNumbers.empty()) {
                array[i] = oddNumbers.pop();
            } else if (!zeroNumbers.empty()) {
                array[i] = zeroNumbers.pop();
            } else if (!otherNumbers.empty()) {
                array[i] = otherNumbers.pop();
            }
        }
    }
}