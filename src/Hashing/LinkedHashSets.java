package Hashing;

import java.util.LinkedHashSet;

public class LinkedHashSets {
    public static void main(String[] args) {
        LinkedHashSet<String> city=new LinkedHashSet<>();

        city.add("Kolkata");
        city.add("Mumbai");
        city.add("Hyderabad");
        city.add("Bengaluru");

        System.out.println(city);
    }
}
//orders