package io.algopreorg.alog.orderedstream;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {
    private int currentIndex;
    private final String[] array;

    public OrderedStream(int n) {
        this.array = new String[n];
        this.currentIndex = 0;
    }

    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<>();
        array[idKey - 1] = value;

        if (idKey - 1 != currentIndex) {
            return result;
        }

        while (currentIndex < array.length && array[currentIndex] != null) {
            result.add(array[currentIndex]);
            currentIndex++;
        }

        return result;
    }
}
