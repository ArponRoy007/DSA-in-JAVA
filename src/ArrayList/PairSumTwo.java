package ArrayList;

import java.util.ArrayList;

//find if any pair in a sorted & rotated ArrayList has a target sum
public class PairSumTwo {
    //2 pointer
    public  static boolean pairSum2(ArrayList<Integer> list, int target) {
        int bp=-1;
        for (int i=0; i<list.size(); i++){
            if (list.get(i)>list.get(i+1)){
                bp=i;
                break;
            }
        }

        int n=list.size();
        int lp = bp+1;
        int rp = bp;

        while (lp!=rp){
            //case1
            if (list.get(lp)+list.get(rp)==target){
                return true;
            }
            //case2
            if (list.get(lp)+list.get(rp)<target){
                lp=(lp+1)%n;
            } else {
                rp=(n-rp-1)%n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();

        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target=15;
        System.out.println(pairSum2(list,target));
    }
}
