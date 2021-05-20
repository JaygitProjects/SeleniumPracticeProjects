package JavaConcepts.CollectionDemo;

import org.testng.annotations.Test;

import java.util.*;

public class ArrayListTrial {
    @Test
    public void testArrayList() {


        List<String> arrayList = new ArrayList<String>();

        arrayList.add("Jay");
        arrayList.add("8. Oakey Drive");
        arrayList.add(("Wokingham"));
        arrayList.add("England");


        System.out.println("Array  List :" + arrayList);

        arrayList.add("Jay");//adding duplicate
        System.out.println("After adding duplicate : " + arrayList);
        System.out.println("Get method :" + arrayList.get(1));

        arrayList.add(4, "UK");

        System.out.println("After adding UK at index 4 : " + arrayList);
        arrayList.set(0, "Jayanthi");

        System.out.println("Set method : " + arrayList);


        System.out.println("Is empty method : " + arrayList.isEmpty());

        System.out.println("Index of method : " + arrayList.indexOf("Wokingham"));

        System.out.println("Last index : " + arrayList.lastIndexOf("Jay"));

        System.out.println("Hash code :" + arrayList.hashCode());


        System.out.println("Array size :" + arrayList.size());

        Collections.sort(arrayList);

        System.out.println("After sorting : " + arrayList);  //upper case gets the priority in sorting

        System.out.println("Sublist :" + arrayList.subList(2, 3));


        System.out.println("Contains method : " + arrayList.contains("Jay"));

        System.out.println("Contains All method :" + arrayList.containsAll(arrayList));

        System.out.println("Equals : " + arrayList.equals("Jay"));

        List dummyList = new ArrayList();

        dummyList.addAll(arrayList);

        System.out.println("Dummy List :" + dummyList);
        //for loop
        System.out.println("\n **for loop ***");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("Element at : " + i + "th position : " + arrayList.get(i));
        }

        //for each loop
        System.out.println("\n **For each loop **");
        for (Object element : dummyList) {
            System.out.println(element);
        }
        //iterator
        System.out.println("\n ***Iterator*** ");
        Iterator iter = arrayList.iterator();
        while (iter.hasNext()) {
            System.out.println("By Iterator : " + iter.next());
        }
        //list iterator
        System.out.println("\n **List Iterator**");
        ListIterator listIter = arrayList.listIterator();
        while (listIter.hasNext()) {
            System.out.println("List Iterator Next Method : " + listIter.next());
        }
        while (listIter.hasPrevious()) {
            System.out.println("List Iterator Previous method : " + listIter.previous());
        }


        dummyList.clear();

        System.out.println("After Clear method : " + dummyList);
        System.out.println("\n ******************Linked List*********************");
        LinkedList lList = new LinkedList();
        lList.add("Jay");
        lList.add("8. Oakey Drive");
        lList.add(("Wokingham"));
        lList.add("England");

        System.out.println(lList);
        Collections.sort(lList);
        System.out.println(lList);
        System.out.println("After sorting : " + lList);
    }
    }
