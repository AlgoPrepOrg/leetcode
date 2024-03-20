package io.algopreorg.alog.removeDuplicates;

public class SolutionVitalii {

    public int removeDuplicates(int[] nums) {
        int uniqueSize = 1;
        int index = 0;
        int fast = 1;

        while (fast != nums.length) {
            if (nums[index] != nums[fast]) {
                nums[index + 1] = nums[fast];
                index++;
                uniqueSize++;
            }
            fast++;
        }
        return uniqueSize;
    }

}
