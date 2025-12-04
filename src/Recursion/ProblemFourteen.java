package Recursion;
//binary string problem
public class ProblemFourteen {
    public static void printBinString(int n, int lastPlace, StringBuilder str){
        //base case
        if (n==0){
            System.out.println(str);
            return;
        }
        //kam
        if (lastPlace==0){
            //sit 0 on chair n
            printBinString(n-1, 0, str.append("0"));
            printBinString(n-1, 1, str.append("1"));
        } else {
            printBinString(n-1, 0, str.append("0"));
        }
    }

    public static void main(String[] args) {
        printBinString(3, 0, new StringBuilder(""));
    }
}
