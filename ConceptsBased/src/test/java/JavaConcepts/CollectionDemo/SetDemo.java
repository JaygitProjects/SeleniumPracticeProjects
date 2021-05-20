package JavaConcepts.CollectionDemo;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    @Test
    public void testHashSet() {

        Set hSet = new HashSet();
    hSet.add("Jay");
        hSet.add("8. Oakey Drive");
        hSet.add(("Wokingham"));
        hSet.add("England");
        System.out.println("** HashSet ***");
        System.out.println(hSet);//insertion order is not maintained
        hSet.add("Jay");//cant add duplicates to set
        System.out.println("After adding duplicates : " + hSet);

        hSet.remove("Jay");
        System.out.println("Remove(object) method : " + hSet);
        System.out.println(hSet.toString());
        //for each loop
       for(Object element:hSet){
           System.out.println(element);
       }
       //for loop
        for(int i = 0;i<hSet.size();i++){

        }
        //Linked Hash Set
        Set linkedHashSet= new LinkedHashSet();
        linkedHashSet.addAll(hSet);
        System.out.println("\n *** Linked Has Set ****");
        linkedHashSet.add("Jay");
        linkedHashSet.add("  ");
        hSet.add("Jay");
        hSet.add("  ");

        System.out.println("Size : " + hSet.size());
        System.out.println("Equals Method: " + hSet.equals(linkedHashSet));

        //Tree Set
        System.out.println("***** Tree Set *****");
        Set treeSet = new TreeSet();
        treeSet.addAll(linkedHashSet);
        System.out.println(treeSet);
        treeSet.add("  ");
       // treeSet.add(null); //null value not allowed in treeSet/treeMap
        treeSet.add("Jay");//duplicate value wont be added

       // All 3 Sets
        System.out.println("Linked Hash Set : "+ linkedHashSet);//insertion order maintained
        System.out.println("Hash Set : " + hSet);//insertion order not maintained
        System.out.println("Tree Set : " + treeSet);//insertion order not maintained
    }
}
