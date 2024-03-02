package io.algopreorg.alog.productExceptSelf;

public class Solution {

    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] answers = new int[n];

        for (int i = 0; i < n; i++) {
            int answer = 1;
            for (int j  = 0; j < n; j++) {
                if (i != j) {
                    answer *= nums[j];
                }
            }

            answers[i] = answer;
        }


        return answers;
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answers = new int[n];
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];

        leftProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }

        rightProducts[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            answers[i] = leftProducts[i] * rightProducts[i];
        }


        return answers;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage:
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}


