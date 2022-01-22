package com.epam.autotasks.collections;

import java.util.*;

class RangedOpsIntegerSet extends AbstractSet<Integer> {

    Set<Integer> set;

    public RangedOpsIntegerSet(){
        set = new TreeSet<>();
    }

    public boolean add(int fromInclusive, int toExclusive) {
        boolean result = false;
        for(int i = fromInclusive; i < toExclusive; i++){
            if(set.add(i)){
                result = true;
            }
        }
        return result;
    }

    public boolean remove(int fromInclusive, int toExclusive) {
        return set.removeIf(i -> (i >= fromInclusive) && (i < toExclusive));
    }

    @Override
    public boolean add(final Integer integer) {
        return set.add(integer);
    }

    @Override
    public boolean remove(final Object o) {
        return set.remove(o);
    }

    @Override
    public Iterator<Integer> iterator() {
        return set.iterator();
    }

    @Override
    public int size() {
        return set.size();
    }

}
