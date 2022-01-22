package com.efimchick.ifmo;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        IntStream.iterate(1, i -> i + 1).limit(5).forEach(System.out::println);
    }

}
