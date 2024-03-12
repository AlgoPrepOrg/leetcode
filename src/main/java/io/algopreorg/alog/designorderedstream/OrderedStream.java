package io.algopreorg.alog.designorderedstream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderedStream {
    private String[] array;
    private int startIndex = 0;

    public OrderedStream(int n) {
        array = new String[n];
        Arrays.fill(array, "-1");
    }

    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<>();
        array[idKey - 1] = value;
        for (int i = startIndex; i < array.length; i++) {
            if (!"-1".equals(array[i])) {
                result.add(array[i]);
            } else {
                startIndex = i;
                break;
            }
        }
        return result;
    }
}
