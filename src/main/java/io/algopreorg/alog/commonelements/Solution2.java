package io.algopreorg.alog.commonelements;

import java.util.Arrays;
import java.util.List;

public class Solution2 {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        List<Integer> nums1List = Arrays.stream(nums1).boxed().toList();
        List<Integer> nums2List = Arrays.stream(nums2).boxed().toList();
        
        int occurrences1 = this.elementsOccurrences(nums1List, nums2List);
        int occurrences2 = this.elementsOccurrences(nums2List, nums1List);
        
        return new int[]{occurrences1, occurrences2};
    }
    
    private int elementsOccurrences(List<Integer> list1, List<Integer> list2) {
        int count = 0;
        for (int num : list1) {
            if (list2.contains(num)) {
                count++;
            }
        }
        
        return count;
    }
    
}
