package io.algopreorg.alog.consistenthashsing;

@FunctionalInterface
public interface HashFunction {

    int hash(String key);

}
