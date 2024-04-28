package io.algopreorg.alog.consistenthashsing;

import java.util.*;

public class ConsistentHashing {
    private final TreeMap<Integer, String> hashRing;
    private final int numberOfReplicas;
    private final HashFunction hashFunction;

    public ConsistentHashing(int numberOfReplicas, List<String> nodes, HashFunction hashFunction) {
        this.hashFunction = hashFunction;
        this.hashRing = new TreeMap<>();
        this.numberOfReplicas = numberOfReplicas;

        for (String node : nodes) {
            addNode(node);
        }
    }

    private void addNode(String node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            int hash = hashFunction.hash(node + i);
            hashRing.put(hash, node);
        }
    }

    private void removeNode(String node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            int hash = hashFunction.hash(node + i);
            hashRing.remove(hash);
        }
    }

    public String getNodeForKey(String key) {
        if (hashRing.isEmpty()) {
            return null;
        }
        int hash = hashFunction.hash(key);
        SortedMap<Integer, String> tailMap = hashRing.tailMap(hash);
        Integer nodeHash = !tailMap.isEmpty() ? tailMap.firstKey() : hashRing.firstKey();
        return hashRing.get(nodeHash);
    }

    public static void main(String[] args) {
        List<String> nodes = Arrays.asList("Node1", "Node2", "Node3");

        HashFunction sha256HashFunction = new Sha256HashFunction();
        ConsistentHashing ch = new ConsistentHashing(3, nodes, sha256HashFunction);

        System.out.println("Key1 belongs to node: " + ch.getNodeForKey("Key1"));
        System.out.println("Key2 belongs to node: " + ch.getNodeForKey("Key2"));

        System.out.println("================================================");

        ch.addNode("Node4");
        System.out.println("After adding Node4, Key1 belongs to node: " + ch.getNodeForKey("Key1"));
        System.out.println("After adding Node4, Key2 belongs to node: " + ch.getNodeForKey("Key2"));

        System.out.println("================================================");

        ch.removeNode("Node1");
        System.out.println("After removing Node1, Key1 belongs to node: " + ch.getNodeForKey("Key1"));
        System.out.println("After removing Node1, Key2 belongs to node: " + ch.getNodeForKey("Key2"));
    }
}
