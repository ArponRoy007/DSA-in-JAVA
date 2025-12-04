package Backtracking;

public class FindSubsets {
    public static void findSubSets(String str, String ans, int i){
        //base case
        if (i == str.length()){
            if (ans.length() == 0){
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        //recursion
        //yes choice - include current character
        findSubSets(str, ans + str.charAt(i), i + 1);
        //no choice - exclude current character (FIXED: increment i)
        findSubSets(str, ans, i + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        findSubSets(str, "", 0);
    }
}