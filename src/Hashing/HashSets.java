package Hashing;

import javax.swing.text.html.HTMLDocument;
import java.util.HashSet;
import java.util.Iterator;

public class HashSets {
    public static void main(String[] args) {
//        HashSet<Integer> set=new HashSet<>();
//
//        set.add(1);
//        set.add(2);
//        set.add(4);
//        set.add(2);
//        set.add(1);
//
//        System.out.println(set);
//        System.out.println(set.size());
//        System.out.println(set.contains(2));
//        System.out.println(set.isEmpty());
//        set.remove(1);
//        System.out.println(set);


        HashSet<String> cities=new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

//        Iterator it= cities.iterator();
//
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }

        for (String city:cities){
            System.out.println(city);
        }
    }
}
