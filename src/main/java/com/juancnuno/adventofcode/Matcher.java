package com.juancnuno.adventofcode;

import java.util.regex.Pattern;

public final class Matcher {

    private final java.util.regex.Matcher matcher;

    public Matcher(Pattern pattern, String string) {
        matcher = pattern.matcher(string);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(string);
        }
    }

    public int intGroup(int group) {
        return Integer.parseInt(matcher.group(group));
    }

    public String group(int group) {
        return matcher.group(group);
    }
}
