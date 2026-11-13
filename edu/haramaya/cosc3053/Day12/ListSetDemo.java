
package edu.haramaya.cosc3053.Day12;

import java.util.*;

public class ListSetDemo {

    public static void main(String[] args) {

        // TODO 12.1: Create ArrayList and LinkedList

        List<String> arrayList = new ArrayList<>();

        arrayList.add("Abebe");
        arrayList.add("Kebede");
        arrayList.add("Almaz");

        List<String> linkedList = new LinkedList<>();

        linkedList.add("Abebe");
        linkedList.add("Kebede");
        linkedList.add("Almaz");

        // Compare random access
        System.out.println("ArrayList element: " + arrayList.get(2));

        System.out.println("LinkedList element: " + linkedList.get(2));


        // TODO 12.2: Add duplicate elements to HashSet

        Set<String> uniqueNames = new HashSet<>();

        uniqueNames.add("Abebe");
        uniqueNames.add("Kebede");
        uniqueNames.add("Abebe");
        uniqueNames.add("Almaz");

        System.out.println("HashSet Unique Elements: " + uniqueNames);


        // TODO 12.3: Demonstrate natural sorting using TreeSet

        Set<String> sortedNames = new TreeSet<>();

        sortedNames.add("Kebede");
        sortedNames.add("Abebe");
        sortedNames.add("Almaz");
        sortedNames.add("Abebe");

        System.out.println("TreeSet Sorted Elements: " + sortedNames);
    }
}
