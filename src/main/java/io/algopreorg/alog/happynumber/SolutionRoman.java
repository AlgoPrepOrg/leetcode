package io.algopreorg.alog.happynumber;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/happy-number/description/
/**
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1*1 + 9*9 = 82
 * 8*8 + 2*2 = 68
 * 6*6 + 8*8 = 100
 * 1*1 + 0*0 + 0*0 = 1
 */
public class SolutionRoman {
    public boolean isHappy(int n) {

        // create a HashSet to detect cycle in creating numbers
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(n);
        while (n != 1) {
            n = getNumber(n);
            if (!integerSet.add(n)) {
                return false;
            }
        }
        return true;
    }

    // calculate the sum of digits in power of 2 (19 -> 1*1 + 9*9 = 82)
    public int getNumber(int number) {
        int num = 0;
        while (number != 0) {
            num += Math.pow(number % 10, 2);
            number /= 10;
        }
        return num;
    }
}
