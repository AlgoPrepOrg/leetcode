package io.algopreorg.alog.commonelements;

public class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] result = new int[2];
        int[] array = new int[101];
        for (int j : nums1) {
            array[j] = 1;
        }
        for (int j : nums2) {
            array[j] = array[j] >= 1 ? 2 : 0;
        }

        for (int j : nums1) {
            if (array[j] > 1) {
                result[0]++;
            }
        }

        for (int j : nums2) {
            if (array[j] > 1) {
                result[1]++;
            }
        }
        return result;
    }
}
