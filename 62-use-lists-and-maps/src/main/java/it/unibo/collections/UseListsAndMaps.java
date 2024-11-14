package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> numberList1 = new ArrayList<Integer>();
        for(int i=0; i<1000; i++) {
            numberList1.add(1000+i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> numberList2 = new LinkedList<Integer>(numberList1);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int index = numberList1.size() - 1;
        numberList1.set(index , numberList1.get(0));
        numberList1.set(0,numberList1.get(index));
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(Integer i:numberList1){
            System.out.print(i + " ");
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        int ELEMS = 100_000;
        long time1 = System.nanoTime();
        for(int i=1; i<=ELEMS; i++) {
            numberList1.add(0, i);
            numberList2.addFirst(i);
        }
        time1 = System.nanoTime() - time1;
        final var millis1 = TimeUnit.NANOSECONDS.toMillis(time1);
        System.out.println( "\n" +
            "Inserting " + ELEMS + " elements in two different lists took " + time1 + "ns (" + millis1 + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        long time2 = System.nanoTime();
        for(int i=0; i<1000; i++) {
            numberList1.get(numberList1.size()/2);
            numberList2.get(numberList2.size()/2);
        }
        time2 = System.nanoTime() - time2;
        final var millis2 = TimeUnit.NANOSECONDS.toMillis(time2);
        System.out.println(
            "Reading 1000 times an element whose position is in the middle of the collection for both ArrayList and LinkedList took " + time2 + "ns (" + millis2 + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String,Long> continentsMap = new HashMap<>();
        continentsMap.put("Africa", 1_110_635_000L);
        continentsMap.put("Americas", 972_005_000L);
        continentsMap.put("Antartica", 0L);
        continentsMap.put("Asia", 4_298_723_000L);
        continentsMap.put("Europe", 742_452_000L);
        continentsMap.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        Long totalPopulation = 0L;
        for (Long population : continentsMap.values()) {
            totalPopulation += population;  // Somma i valori
        }
        System.out.println("World population: " + totalPopulation);
    }
}
