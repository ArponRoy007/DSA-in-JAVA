package Hashing;

import java.util.TreeSet;

public class TreeSets {
    public static void main(String[] args) {
        TreeSet<String> ts=new TreeSet<>();
        ts.add("Pune");
        ts.add("Visakhapatnam");
        ts.add("Noida");
        System.out.println(ts);
    }
}
//null is not allowed
//sorted according to letter
//use red black tree....