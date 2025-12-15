package Hashing;

import java.util.*;

public class LinkedHashmaps {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm=new LinkedHashMap<>();

        lhm.put("A", 4);
        lhm.put("T", 98);
        lhm.put("J", 34);

        System.out.println(lhm);
    }
}

//hashmap and this linkedHashmap all are same only
//when we need order list then we use this one.

//it use double linked list data structure.
