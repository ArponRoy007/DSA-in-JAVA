package ArrayList;

import java.util.ArrayList;

public class MultidimensionalArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList=new ArrayList<>();

//        ArrayList<Integer> list=new ArrayList<>();
//        list.add(1); list.add(2);
//        mainList.add(list);
//
//        ArrayList<Integer> list2=new ArrayList<>();
//        list2.add(3); list2.add(4);
//        mainList.add(list2);
//
//        for (int i=0; i<mainList.size(); i++){
//            ArrayList<Integer> currList=mainList.get(i);
//            for (int j=0; j<currList.size(); j++){
//                System.out.print(currList.get(j));
//            }
//            System.out.println();
//        }
//        System.out.println(mainList);

        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        ArrayList<Integer> list3=new ArrayList<>();

        for (int i=1; i<=5; i++){
            list1.add(i*1);//12345
            list2.add(i*2);//246810
            list3.add(i*3);//3691215
        }
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        System.out.println(mainList);

        //l1,l2,l3
        for (int i=0; i<mainList.size(); i++){
            ArrayList<Integer> currList=mainList.get(i);
            for (int j=0; j<currList.size(); j++){
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }
    }
}
