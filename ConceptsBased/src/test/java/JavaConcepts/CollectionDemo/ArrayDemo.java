package JavaConcepts.CollectionDemo;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayDemo {
    @Test
    public void testArray() {
        ArrayList arrayList = new ArrayList<>();
        arrayList.add("Raj");
        arrayList.add("Jay");
        arrayList.add("Shar");
        arrayList.add("Adhav");
        System.out.println("Array List: " + arrayList);
        System.out.println("Get function : " + arrayList.get(1));
        System.out.println("Clone : " + arrayList.clone());
        System.out.println("to array method : " + Arrays.toString(arrayList.toArray()));
        ArrayList dummyList = new ArrayList();
        System.out.println("Add all : " + dummyList.addAll(arrayList));
        System.out.println("Dummy List : " + dummyList);
        //loops
        System.out.println("** For loop **");
        for (Object element : arrayList) {
            System.out.println(element);
        }
    }
    //iterator

}