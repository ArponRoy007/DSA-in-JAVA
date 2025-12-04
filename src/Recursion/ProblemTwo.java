package Recursion;

//Print numbers from n to 1 (Increasing Order)
public class ProblemTwo {
    public static void printInc(int n){
        if (n==0){
            return;
        }
        printInc(n-1);
        System.out.println(n+" ");
    }
    public static void main(String[] args) {
        int n=10;
        printInc(n);
    }
}
