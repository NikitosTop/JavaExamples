package com.epam.rd.autocode.decorator;

import java.util.List;
import java.util.stream.Collectors;

public class Decorators {
    public static List<String> evenIndexElementsSubList(List<String> sourceList) {

        return sourceList.stream().filter(x -> sourceList.indexOf(x) % 2 == 0).collect(Collectors.toList());
    }


}
