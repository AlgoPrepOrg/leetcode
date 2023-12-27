package io.algopreorg.alog.orderedstream;

import java.util.*;

public class OrderedStream2 {

    private final Map<Integer, String> values;
    
    private Integer ptr;

    public OrderedStream2(int n) {
        this.values = new HashMap<>(n);
        this.ptr = 1;
        
        for (int i = 1; i <= n; i++) {
            values.put(i, null);
        }
    }

    public List<String> insert(int idKey, String value) {
        if (Objects.isNull(value)) {
            return null;
        } else if (idKey <= values.size()) {
            values.put(idKey, value);
            
            List<String> strs = new ArrayList<>();
            
            for (int i = idKey; i <= values.size() && Objects.nonNull(values.get(i)) && idKey <= ptr; i++) {
                strs.add(values.get(i));
                ptr = i + 1;
            }
            
            return strs;
        } else {
            return Collections.emptyList();
        }
    }
    
}
