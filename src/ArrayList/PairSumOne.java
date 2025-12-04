package ArrayList;

import java.util.ArrayList;

public class PairSumOne {
    //2 pointer
    public  static boolean pairSum1(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size() - 1;

        while (lp!=rp){
            //case1
            if (list.get(lp)+list.get(rp)==target){
                return true;
            }
            //case2
            if (list.get(lp)+list.get(rp)<target){
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        //1,2,3,4,5
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int target=5;
        System.out.println(pairSum1(list,target));
    }
}
