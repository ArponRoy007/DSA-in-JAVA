package Recursion;

//Print number of n to 1 (Decreasing Order)

public class ProblemOne {
    public static void printDec(int n){
        if (n==0){
            return;
        }
        System.out.println(n+" ");
        printDec(n-1);
    }
    public static void main(String[] args) {
        int n=10;
        printDec(n);
    }
}

