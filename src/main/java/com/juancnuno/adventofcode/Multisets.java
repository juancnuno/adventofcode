package com.juancnuno.adventofcode;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public final class Multisets {

    private Multisets() {
    }

    public static <K> Collector<K, ?, Map<K, Integer>> toMultiset() {
        return Collectors.toMap(key -> key, key -> 1, Integer::sum);
    }

    public static <K> void put(Map<K, Integer> multiset, K key, int count) {
        multiset.merge(key, count, Integer::sum);
    }
}
