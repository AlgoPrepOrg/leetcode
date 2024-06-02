package io.algopreorg.alog.twoSum;

public class SolutionMariana {

    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        while (index1 != index2) {
            int sum = numbers[index1] + numbers[index2];

            if (sum == target) {
                return new int[]{index1 + 1, index2 + 1};
            } else if (sum < target) {
                index1++;
            } else {
                index2--;
            }
        }

        return new int[]{};
    }
}
