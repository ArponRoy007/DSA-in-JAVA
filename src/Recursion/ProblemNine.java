package Recursion;

public class ProblemNine {
    //tc=O(n)
//    public static int power(int x, int n){
//        if (n==0){
//            return 1;
//        }
//        return x*power(x,n-1);
//    }


    //tc=O(logn)
    public static int optimizedPower(int a, int n){
        if (n==0){
            return 1;
        }
        int halfPower = optimizedPower(a, n/2);
        int halfPowerSq = halfPower*halfPower;

        //n os odd
        if (n%2!=0){
            halfPowerSq=a*halfPowerSq;
        }
        return halfPowerSq;
    }

    public static void main(String[] args) {
        System.out.println(optimizedPower(2,10));
    }
}
