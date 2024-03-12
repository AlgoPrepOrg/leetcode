package io.algopreorg.alog.goodpairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Solution4Test {

    private final Solution4 numberOfGoodPairs = new Solution4();

    @ParameterizedTest
    @MethodSource("provideParams")
    void testNumberOfGoodPairs(int[] arr, int expected) {
        int result = numberOfGoodPairs.numIdenticalPairs(arr);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1, 1, 3}, 4),
                Arguments.of(new int[]{1, 1, 1, 1}, 6),
                Arguments.of(new int[]{1, 2, 3}, 0)
        );
    }
}