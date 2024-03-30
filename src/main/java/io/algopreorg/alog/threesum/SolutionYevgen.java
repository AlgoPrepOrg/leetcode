package io.algopreorg.alog.threesum;

import java.util.*;

public class SolutionYevgen {

    //time O(n^2) space - O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();

        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length -1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
            }
        }

        return new ArrayList<>(res);
    }
}
