package io.algopreorg.alog.commonelements;

import java.util.*;
import java.util.stream.Collectors;

public class Solution3 {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> nums2Set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        int occurrences1 = elementsOccurrences(nums1, nums2Set);
        int occurrences2 = elementsOccurrences(nums2, nums1Set);

        return new int[]{occurrences1, occurrences2};
    }

    private int elementsOccurrences(int[] nums, Set<Integer> list2) {
        int count = 0;
        for (int num : nums) {
            if (list2.contains(num)) {
                count++;
            }
        }

        return count;
    }
}
