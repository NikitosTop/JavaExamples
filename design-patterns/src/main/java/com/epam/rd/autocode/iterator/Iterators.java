package com.epam.rd.autocode.iterator;

import java.util.*;

class Iterators {

    public static Iterator<Integer> intArrayTwoTimesIterator(int[] array){
        int[] result = new int[array.length * 2];
        int count = 0;
        int index = 0;
        for(int i = 0; i < result.length; i++){
            if(count == 2){
                count = 0;
                index++;
            }
            result[i] = array[index];
            count++;
        }

        System.out.println(Arrays.toString(result));
        return Arrays.stream(result).iterator();
    }

    public static Iterator<Integer> intArrayThreeTimesIterator(int[] array) {
        int[] result = new int[array.length * 3];
        int count = 0;
        int index = 0;
        for(int i = 0; i < result.length; i++){
            if(count == 3){
                count = 0;
                index++;
            }
            result[i] = array[index];
            count++;
        }

        System.out.println(Arrays.toString(result));
        return Arrays.stream(result).iterator();

    }

    public static Iterator<Integer> intArrayFiveTimesIterator(int[] array) {
        int[] result = new int[array.length * 5];
        int count = 0;
        int index = 0;
        for(int i = 0; i < result.length; i++){
            if(count == 5){
                count = 0;
                index++;
            }
            result[i] = array[index];
            count++;
        }

        System.out.println(Arrays.toString(result));
        return Arrays.stream(result).iterator();
    }

    public static Iterable<String> table(String[] columns, int[] rows){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < columns.length; i++){
            for(int j = 0; j < rows.length; j++){
                list.add(columns[i] + rows[j]);
            }
        }
        return list;
    }



}
