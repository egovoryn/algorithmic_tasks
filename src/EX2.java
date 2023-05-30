import java.util.*;

public class EX2 {

    public static void main(String[] args) {
//        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Integer[] array = GenerateArray.generateArray(10);

        System.out.println("Source array: " + Arrays.toString(array));
        ArrayList<Integer> mostFrequentNumbers = findMostFrequentNumbers(array); // находим наиболее часто встречающиеся числа
        System.out.println("Most common nums: " + mostFrequentNumbers);
    }

    private static ArrayList<Integer> findMostFrequentNumbers(Integer[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Integer maxFrequency = 0;
        for (Integer number : array) {
            if (frequencyMap.containsKey(number)) {
                frequencyMap.put(number, frequencyMap.get(number) + 1);
            } else {
                frequencyMap.put(number, 1);
            }

            if (frequencyMap.get(number) > maxFrequency) {
                maxFrequency = frequencyMap.get(number);
            }
        }

        ArrayList<Integer> mostFrequentNumbers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (Objects.equals(entry.getValue(), maxFrequency)) {
                mostFrequentNumbers.add(entry.getKey());
            }
        }

        return mostFrequentNumbers;
    }
}

