package com.juancnuno.adventofcode;

import java.util.stream.Stream;

public final class CharSequences {

    private CharSequences() {
    }

    public static Stream<Character> chars(CharSequence sequence) {
        return sequence.chars().mapToObj(c -> (char) c);
    }
}
