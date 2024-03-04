package io.algopreorg.alog.commonelements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Solution4Test {

    private final Solution4 findCommonElementsBetweenTwoArrays = new Solution4();

    @ParameterizedTest
    @MethodSource("methodArguments")
    void findsCommonElements(int[] nums1, int[] nums2, int[] expected) {
        int[] result = findCommonElementsBetweenTwoArrays.findIntersectionValues(nums1, nums2);

        Assertions.assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> methodArguments() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 2, 3, 1}, new int[]{2, 2, 5, 2, 3, 6}, new int[]{3, 4}),
                Arguments.of(new int[]{3, 4, 2, 3}, new int[]{1, 5}, new int[]{0, 0})
        );
    }

}