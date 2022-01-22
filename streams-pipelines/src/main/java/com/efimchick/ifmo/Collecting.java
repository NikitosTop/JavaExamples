package com.efimchick.ifmo;


import com.efimchick.ifmo.util.CourseResult;
import com.efimchick.ifmo.util.Person;
import com.google.common.collect.ImmutableCollection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collecting{

    private java.lang.Object Object;

    public int sum(IntStream stream){
        return stream.sum();
    }

    public int production(IntStream stream){
        return stream.reduce(1, (a, b) -> a * b);
    }

    public int oddSum(IntStream stream){
        return stream.filter(x -> x % 2 != 0).sum();
    }

    public Map<Integer, Integer> sumByRemainder(int count, IntStream stream){
        return stream.boxed().collect(Collectors.groupingBy(n -> n % count, Collectors.summingInt(n -> n)));
    }

    public Map<Person, Double> totalScores(Stream<CourseResult> courseResultStream){
        List<CourseResult> list = courseResultStream.collect(Collectors.toList());
        list.forEach(System.out::println);
        Map<Person, Double> map = new LinkedHashMap<>();
        for(int i = 0; i < list.size(); i++){
            double sum = 0;
            for(String a:list.get(i).getTaskResults().keySet()){
                sum += list.get(i).getTaskResults().get(a);
            }
            map.put(list.get(i).getPerson(), sum/list.size());
        }
        Map<Person, Double> mapResult = Map.copyOf(map);
        return mapResult;
    }
    public int averageTotalScore(Stream<CourseResult> courseResultStream){
        return 0;
    }


    public Map<String, Double> averageScoresPerTask(Stream<CourseResult> programmingResults) {
        return Collections.emptyMap();
    }


    public <V, K> Map<K,V> defineMarks(Stream<CourseResult> programmingResults) {
        return Collections.emptyMap();
    }

    public String easiestTask(Stream<CourseResult> programmingResults) {
        return "fake";
    }

}
