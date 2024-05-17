package io.algopreorg.alog.slicingwindow;

import io.algopreorg.alog.slicingwindow.containsduplicate.SolutionRoman;

public class Demo {
    public static void main(String[] args) {
        SolutionRoman solutionRoman = new SolutionRoman();
        int[] nums = new int[]{1,2,3,1,2,3};
        int k = 2;
        System.out.println(solutionRoman.containsNearbyDuplicate(nums, k));
    }
}
