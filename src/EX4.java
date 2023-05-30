import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EX4 {
    public static void main(String[] args) {
        int[] numbers = {17, 12, 10, 4, 9, 8};
        int numGroups = 2;

        List<List<Integer>> result = distributeNumbers(numbers, numGroups);
        System.out.println("Source array: " + Arrays.toString(numbers));
        if (result != null) {
            System.out.println("Result:");
            for (List<Integer> group : result) {
                System.out.println(group);
            }
        } else {
            System.out.println("Impossible");
        }
    }

    private static List<List<Integer>> distributeNumbers(int[] numbers, int numGroups) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        if (sum % numGroups != 0) {
            return null;
        }

        int targetSum = sum / numGroups;
        List<List<Integer>> result = new ArrayList<>();
        int[] groupSums = new int[numGroups];

        if (!isDistribute(numbers, 0, targetSum, groupSums)) {
            return null;
        }

        for (int i = 0; i < numGroups; i++) {
            result.add(new ArrayList<>());
        }

        for (int number : numbers) {
            int groupIndex = getSmallestGroupIndex(groupSums);
            result.get(groupIndex).add(number);
            groupSums[groupIndex] += number;
        }

        return result;
    }

    private static boolean isDistribute(int[] numbers, int index, int targetSum, int[] groupSums) {
        if (index >= numbers.length) {
            return true;
        }
        int num = numbers[index];
        for (int i = 0; i < groupSums.length; i++) {
            if (groupSums[i] + num <= targetSum) {
                groupSums[i] += num;
                if (isDistribute(numbers, index + 1, targetSum, groupSums)) {
                    return true;
                }
                groupSums[i] -= num;
            }
        }
        return false;
    }

    private static int getSmallestGroupIndex(int[] groupSums) {
        int minIndex = 0;
        int minSum = groupSums[0];
        for (int i = 1; i < groupSums.length; i++) {
            if (groupSums[i] < minSum) {
                minIndex = i;
                minSum = groupSums[i];
            }
        }
        return minIndex;
    }
}
