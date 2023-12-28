package com.juancnuno.adventofcode;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public final class Multisets {

    private Multisets() {
    }

    public static <K> Collector<K, ?, Map<K, Integer>> toMultiset() {
        return Collectors.groupingBy(key -> key, counting());
    }

    public static <K extends Enum<K>> Collector<K, ?, Map<K, Integer>> toEnumMultiset(Class<K> c) {
        return Collectors.groupingBy(key -> key, () -> new EnumMap<>(c), counting());
    }

    private static <K> Collector<K, ?, Integer> counting() {
        return Collectors.summingInt(key -> 1);
    }

    public static <K> void put(Map<K, Integer> multiset, K key, int count) {
        multiset.merge(key, count, Integer::sum);
    }
}
