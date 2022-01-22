package com.efimchick.ifmo.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class PairStringList extends ArrayList {
    List<String> list;

    public PairStringList() {
        list = new ArrayList<>();
    }

    @Override
    public boolean add(Object o) {
        list.add((String) o);
        System.out.println(list.toString());
        return list.add((String) o);
    }

    @Override
    public void add(int index, Object element) {
        if(index == 0){
            list.add(index, (String) element);
            list.add(index, (String) element);
        }else if (list.get(index - 1).equals(list.get(index))){
            list.add(index + 1, (String) element);
            list.add(index + 1, (String) element);
        }else{
            list.add(index, (String) element);
            list.add(index, (String) element);
        }
    }

    @Override
    public Object remove(int index) {
        if(list.get(index).equals(list.get(index - 1))) {
            list.remove(index - 1);
            return list.remove(index - 1);
        }else{
            list.remove(index + 1);
            return list.remove(index);
        }
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean remove(Object o) {
        list.remove(o);
        return list.remove(o);
    }

    @Override
    public Object get(int index) {
        return list.get(index);
    }

    @Override
    public Object set(int index, Object element) {
        if(index == 0){
            list.set(index, (String) element);
            return list.set(index + 1, (String) element);
        }else if (list.get(index - 1).equals(list.get(index))){
            list.set(index - 1, (String) element);
            return list.set(index, (String) element);
        }else{
            list.set(index, (String) element);
            return list.set(index + 1, (String) element);
        }
    }

    @Override
    public boolean addAll(Collection c) {
        for(Object s:c){
            list.add((String) s);
            list.add((String) s);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        ArrayList temp = new ArrayList<>(c);
        if(index == 0){
            for(int i = temp.size() - 1; i >= 0 ; i--){
                list.add(index, (String) temp.get(i));
                list.add(index, (String) temp.get(i));
            }
        }else if (list.get(index - 1).equals(list.get(index))){
            for(int i = temp.size() - 1; i >= 0 ; i--){
                list.add(index + 1, (String) temp.get(i));
                list.add(index + 1, (String) temp.get(i));
            }
        }else{
            for(int i = temp.size() - 1; i >= 0 ; i--){
                list.add(index, (String) temp.get(i));
                list.add(index, (String) temp.get(i));
            }
        }
        return true;
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }

    @Override
    public int size() {
        return list.size();
    }
}
