package io.algopreorg.alog.concatenationofarray;

import java.util.Arrays;
import java.util.stream.Stream;

public class Solution3 {

    public int[] getConcatenation(int[] nums) {
        return Stream.concat(Arrays.stream(nums).boxed(), Arrays.stream(nums).boxed()).mapToInt(v -> v).toArray();
    }
    
}
