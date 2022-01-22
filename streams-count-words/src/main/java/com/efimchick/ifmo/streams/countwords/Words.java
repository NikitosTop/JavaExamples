package com.efimchick.ifmo.streams.countwords;


import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class Words {

    public String countWords(List<String> lines) {
        Pattern pattern = Pattern.compile("\\s+");



        List<String> newList = lines.stream().map(x -> x.replaceAll("[^\\p{L}]", " ")).collect(Collectors.toList());

        Map<String, Long> wordsCount = newList.stream().sorted().flatMap(pattern::splitAsStream)
                .collect(Collectors.groupingBy(String::toLowerCase,
                TreeMap::new, Collectors.counting()));

        String result = wordsCount.entrySet().stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .filter(x -> x.getValue() >= 10)
                .filter(x -> Arrays.stream(x.getKey().split("")).filter(y -> y.matches("\\p{L}")).collect(Collectors.joining("")).length() >= 4)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal) -> oldVal, LinkedHashMap::new)).keySet().stream()
                .map(key -> Arrays.stream(key.split("")).filter(x -> x.matches("\\p{L}"))
                        .collect(Collectors.joining()) + " - " + wordsCount.get(key)).collect(Collectors.joining("\n"));;



        return result;
    }
}
