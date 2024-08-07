package com.juancnuno.adventofcode;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public final class AdventOfCode {

    private AdventOfCode() {
    }

    public static void printResultList(Function<List<String>, Object> function) {
        printResultT(function, Files::readAllLines);
    }

    public static void printResultStream(Function<Stream<String>, Object> function) {
        try (var lines = Files.lines(Path.of(System.getProperty("user.home"), "input.txt"))) {
            System.out.println(function.apply(lines));
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

    public static void printResultString(Function<String, Object> function) {
        printResultT(function, Files::readString);
    }

    private static <T> void printResultT(Function<T, Object> function, PathFunction<T> pathFunction) {
        try {
            var home = System.getProperty("user.home");
            System.out.println(function.apply(pathFunction.apply(Path.of(home, "input.txt"))));
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

    private interface PathFunction<R> {

        R apply(Path path) throws IOException;
    }
}
