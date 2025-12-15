package Hashing;

import java.util.*;

public class HashMaps {
    public static void main(String[] args) {
        //create
        HashMap<String, Integer> hm=new HashMap<>();

        //Insert
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Rasia", 75);
        hm.put("Nepal", 5);

        //OPERATIONS
        //System.out.println(hm);
//        //Get
//        int population=hm.get("India");
//        System.out.println("populations of India is: "+population);
//
//        //it checks the key is in the hashmap or not.
//        System.out.println(hm.containsKey("US"));
//
//        //Remove
//        hm.remove("China");
//        System.out.println(hm);
//
//        //Size
//        System.out.println(hm.size());
//        //check emptiness
//        //hm.clear();
//        System.out.println(hm.isEmpty());

        //ITERATION
        Set<String> keys=hm.keySet();
        System.out.println(keys);

        for (String k:keys){
            System.out.println("Key= "+k+", Value= "+hm.get(k));
        }
    }
}
