package JavaConcepts.CollectionDemo;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeDemo {
    @Test
    public void testTree(){
        Map hashMap = new HashMap<>();
        hashMap.put("Name" ,"Jay");
        hashMap.put("Address 1 " ,"8. Oakey Drive");
        hashMap.put("Address 2 ","Wokingham");
        hashMap.put("Address 3 " ,"England");
        System.out.println(hashMap);
        hashMap.put("Name","Jayanthi");
        System.out.println(hashMap);//no duplicateion allowed so it over write the value for the particular key

        System.out.println("get method : " + hashMap.get("Name"));
        System.out.println("Key set method : " + hashMap.keySet());//returns only keys
        System.out.println("Values method : " + hashMap.values());//return only values
        System.out.println("Entry method : " + hashMap.entrySet());

        // Linked Hash Map
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Name" ,"Jay");
        linkedHashMap.put("Address 1 " ,"8. Oakey Drive");
        linkedHashMap.put("Address 2 ","Wokingham");
        linkedHashMap.put("Address 3 " ,"England");

       //Tree Map

        Map treeMap = new TreeMap();
        treeMap.put("Name" ,"Jay");
        treeMap.put("Address 1 " ,"8. Oakey Drive");
        treeMap.put("Address 2 ","Wokingham");
        treeMap.put("Address 3 " ,"England");

        //printing all for comparing
        System.out.println("\n ***printing all for comparing **");
        System.out.println("Hash Map : " + hashMap);
        System.out.println("Linked Hash MAp : " + linkedHashMap);
        System.out.println("Tree Map : " + treeMap);

        hashMap.put(null, "Null");
        System.out.println("\nHash Map : " + hashMap);//order not maintained

        linkedHashMap.put(null, "Null");
        System.out.println("Linked Hash MAp : " + linkedHashMap);//insertion order maintained

        /*treeMap.put(null,"Null");*/
        /*System.out.println("\nTree Map : " + treeMap); */ // null key not allowed
    }
}
