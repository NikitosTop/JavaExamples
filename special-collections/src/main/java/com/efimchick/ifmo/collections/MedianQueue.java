package com.efimchick.ifmo.collections;

import java.util.*;
import java.util.stream.Collectors;

class MedianQueue extends PriorityQueue{

    Queue<Integer> queue;

    public MedianQueue() {
        queue = new PriorityQueue<>();
    }

    @Override
    public boolean offer(Object o) {
        return queue.offer((Integer) o);
    }

    @Override
    public Object peek() {
        List<Integer> temp = queue.stream().sorted().collect(Collectors.toList());
        if(temp.size() % 2 == 0){
            return temp.get((temp.size() / 2) - 1);
        }
        return temp.get(temp.size()/2);
    }

    @Override
    public Iterator iterator() {
        return queue.iterator();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public Object poll() {
        List <Integer> list = new ArrayList<>(queue);

        Collections.sort(list);
        int num = 0;
        if (list.size() <= 2){
            queue.remove(list.get(0));
            return num = list.get(0);
        }
        if(queue.size() % 2 == 0){
            int first = list.get(list.size()/2 -1 );
            num = first;
            queue.remove(first);
        }else {
            num = list.get(list.size()/2 );
            queue.remove(num);
        }
        return num;
    }
}
