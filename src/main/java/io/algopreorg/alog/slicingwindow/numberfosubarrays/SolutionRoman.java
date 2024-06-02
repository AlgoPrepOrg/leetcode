package io.algopreorg.alog.slicingwindow.numberfosubarrays;

// https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/



public class SolutionRoman {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;
        int sum = 0;
        int target = k * threshold;

        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                sum += arr[i];
            } else {
                if (sum >= target) {
                    result++;
                }
                sum += arr[i] - arr[i - k];
            }
        }

        if (sum >= target) {
            result++;
        }

        return result;
    }
}
