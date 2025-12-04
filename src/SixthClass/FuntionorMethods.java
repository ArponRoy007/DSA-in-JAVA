package SixthClass;

import java.util.*;

public class FuntionorMethods {
    public static void printHelloWorld(){
        System.out.println("Hello World");
    }

    public static int calculateSum(int a, int b){ //parameters of formal parameters
        int sum=a+b;
        return sum;
    }

    public static void swap(int a, int b){
        int temp=a;
        a=b;
        b=temp;
        System.out.println(a +" & "+ b);
    }

    public static int multiply(int a, int b){
        int product=a*b;
        return product;
    }

    public static int factorial(int n){
        int f=1;
        for (int i=1; i<=n; i++){
            f=f*i;
        }
        return f;
    }

    public static int binCoeff(int n, int r){
        int fact_n=factorial(n);
        int fact_r=factorial(r);
        int fact_nmr=factorial(n-r);

        int binCoeff=fact_n/(fact_r*fact_nmr);
        return binCoeff;
    }

//    public static int sum(int a, int b){
//        return a+b;
//    }
//    public static int sum(int a,int b, int c){
//        return a+b+c;
//    }

    public static int sum(int a, int b){
        return a+b;
    }
    public static float sum(float a,float b){
        return a+b;
    }

    public static boolean isPrime(int n){
        //corner cases
        //2
        if (n==2){
            return true;
        }
        for(int i=2; i<=n-1; i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        //printHelloWorld();

        Scanner sc=new Scanner(System.in);
//        int a= sc.nextInt();
//        int b= sc.nextInt();
//        int sum=calculateSum(a,b);//arguments or actual parameters
//        System.out.println(sum);

        //swap-values exchange
//        int a=5;
//        int b=10;
//        swap(a,b);


        //find product a & b
//        int a=3;
//        int b=5;
//        int prod=multiply(a,b);
//        System.out.println("a*b= "+prod);

        //factorial of number,n
//        int a=5;
//        System.out.println(factorial(a));

        //binomial coefficient
//        System.out.println(binCoeff(5,2));

        //function overloading-using parameters
//        System.out.println(sum(3,5));
//        System.out.println(sum(3,4,5));

        //function overloading-using datatype
//        System.out.println(sum(3,5));
//        System.out.println(sum(3.4f,4.5f));

        //check if a num is prime or not
        System.out.println(isPrime(2));
    }
}
