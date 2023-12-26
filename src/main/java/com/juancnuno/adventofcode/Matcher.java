package com.juancnuno.adventofcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

public final class Matcher {

    private final java.util.regex.Matcher matcher;

    public Matcher(Pattern pattern, String string) {
        matcher = pattern.matcher(string);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(string);
        }
    }

    public String group(int group) {
        return matcher.group(group);
    }

    public int intGroup(int group) {
        return Integer.parseInt(matcher.group(group));
    }

    public Collection<Integer> intsGroup(int group) {
        return Arrays.stream(matcher.group(group).split(" +"))
                .map(Integer::parseInt)
                .toList();
    }
}
