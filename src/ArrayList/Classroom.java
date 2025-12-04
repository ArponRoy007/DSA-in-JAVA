package ArrayList;

import java.util.*;

public class Classroom {
    public static void Swap(ArrayList<Integer> list, int idx1, int idx2){
        int temp=list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    public static void main(String[] args) {
        //className objectName=new className();
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        ArrayList<Integer> list3=new ArrayList<>();

        //add
        list.add(2); //O(1)
        list.add(5);
        list.add(3);
        list.add(9);
        list.add(7);
//        list.add(1,9); //O(n)
//        System.out.println(list);
//        //get
//        System.out.println(list.get(2));
//        //remove/delete
//        list.remove(2);
//        System.out.println(list);
//        //setElement
//        list.set(2,10);
//        System.out.println(list);
//        //contains
//        System.out.println(list.contains(1));
//        System.out.println(list.contains(11));

//        System.out.println(list.size());
//        //print the arraylist
//        for (int i=0; i<list.size(); i++){
//            System.out.print(list.get(i));
//        }
//        System.out.println();

        //find maximum  //O(n)
//        int max=Integer.MIN_VALUE;
//        for (int i=0; i<list.size(); i++){
// //            if (max<list.get(i)){
// //                max=list.get(i);
// //            }
//            max=Math.max(max, list.get(i));
//        }
//        System.out.println("Max element= "+max);

        //Swap 2 numbers
//        int idx1=1, idx2=3;
//        Swap(list,idx1,idx2);
//        System.out.println(list);

        //sorting
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

    }
}
