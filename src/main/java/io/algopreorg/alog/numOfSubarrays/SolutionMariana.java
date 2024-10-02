package io.algopreorg.alog.numOfSubarrays;

public class SolutionMariana {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int currentSum = 0;
        int sumThreshold = k * threshold;
        int counter = 0;

        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }

        if (currentSum >= sumThreshold) {
            counter++;
        }

        for (int i = k; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - k];

            if (currentSum >= sumThreshold) {
                counter++;
            }
        }

        return counter;
    }
}
