package com.example.xiacijie.feelsbook;


import java.util.Comparator;

/** a helper class
 * that do the object sorting */
public class ObjectSortUtil implements Comparator<Feel> {
//    https://stackoverflow.com/questions/2784514/sort-arraylist-of-custom-objects-by-property
    @Override
    public int compare(Feel o1, Feel o2) {
        return o2.getRawDate().compareTo(o1.getRawDate());
    }
}
