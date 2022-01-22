package com.efimchick.ifmo.streams.countwords;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list = List.of("привет", "пока", "пока", "да", "бог.", "бог....");
        System.out.println(new Words().countWords(list));
    }

}
