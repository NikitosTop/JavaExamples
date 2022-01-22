package com.efimchick.ifmo.collections;

import java.util.*;

class SortedByAbsoluteValueIntegerSet extends AbstractSet {

    LinkedHashSet<Integer> treeSet;

    public SortedByAbsoluteValueIntegerSet(){
        treeSet = new LinkedHashSet<>();
    }

    @Override
    public Iterator iterator() {
        return treeSet.iterator();
    }

    @Override
    public boolean contains(Object o) {
        return treeSet.contains(o);
    }

    @Override
    public boolean remove(Object o) {
        return treeSet.remove(o);
    }

    @Override
    public int size() {
        return treeSet.size();
    }

    @Override
    public boolean add(Object o) {
        treeSet.add((Integer) o);
        treeSet = new LinkedHashSet<>(sort());
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        treeSet.addAll(c);
        treeSet = new LinkedHashSet<>(sort());
       return true;
    }

    public ArrayList<Integer> sort(){
        ArrayList<Integer> temp = new ArrayList<>(treeSet);
        if (temp.size() > 1){
            for (int j = temp.size() - 1; j >= 1 ; j--){
                for(int i = 0; i < j; i++){
                    if(Math.abs(temp.get(i)) < Math.abs(temp.get(i + 1))){
                        System.out.println("a " + temp.get(i) + " b " + temp.get(i + 1));
                        Collections.swap(temp, i, i + 1);
                    }
                }
            }
        }
        Collections.reverse(temp);
        return temp;
    }

}
