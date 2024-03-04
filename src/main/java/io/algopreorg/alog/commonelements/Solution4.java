package io.algopreorg.alog.commonelements;

public class Solution4 {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int left = calculateCount(nums1, nums2);
        int right = calculateCount(nums2, nums1);
        return new int[]{left, right};
    }

    private int calculateCount(int[] first, int[] second) {
        int count = 0;
        for (int firstNum : first) {
            for (int secondNum : second) {
                if (firstNum == secondNum) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

}
