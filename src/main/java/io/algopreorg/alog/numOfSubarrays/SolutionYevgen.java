package io.algopreorg.alog.numOfSubarrays;

/**
 * 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 *
 * Given an array of integers arr and two integers k and threshold, return the number of sub-arrays of size k and average greater than or equal to threshold.
 *
 * Example 1:
 *
 * Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
 * Output: 3
 * Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).
 * Example 2:
 *
 * Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
 * Output: 6
 * Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 105
 * 1 <= arr[i] <= 104
 * 1 <= k <= arr.length
 * 0 <= threshold <= 104
 */

public class SolutionYevgen {

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int n = arr.length;
        int thresholdSum = k * threshold;
        int currentSum = 0;

        // Initialize the sum of the first window
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }

        // Check if the first window meets the threshold
        if (currentSum >= thresholdSum) {
            ans++;
        }

        // Slide the window over the rest of the array
        for (int i = k; i < n; i++) {
            currentSum += arr[i] - arr[i - k];

            if (currentSum >= thresholdSum) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,1};
        int k = 1;
        int threshold = 0;

        int ans = numOfSubarrays(arr, k, threshold);

        System.out.println("Ans " + ans);
    }
}
