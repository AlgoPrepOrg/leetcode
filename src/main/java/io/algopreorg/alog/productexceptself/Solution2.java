package io.algopreorg.alog.productexceptself;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Solution2 {
    public int[] productExceptSelf(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        if (set.size() < 2) {
            return nums;
        }

        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = 1;
            for (int number : set) {
                if (number != nums[i]) {
                    newNums[i] *= number;
                }
            }
        }
        return newNums;
    }

    private void getProduct(int[] nums, int index, List<Integer> list) {
        nums[index] = 1;
        Stream.iterate(0, i -> i < nums.length, i -> i + 1)
                .filter(i -> i != index)
                .forEach(i -> nums[index] = nums[index] * list.get(i));
    }
}
