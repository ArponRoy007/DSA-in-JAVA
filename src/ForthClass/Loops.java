package ForthClass;

import java.util.*;

public class Loops {
    public static void main(String[] args) {
//        int counter=0;
//        while (counter<=10){
//            System.out.println("Hello World");
//            counter++; // eta na korle choltei thakbe
//        }

        //print number 1 to 10
//        int i=1;
//        while(i<=10){
//            System.out.println(i+" ");
//            i++;
//        }
//        System.out.println();

        //print number from 1 to n
//        Scanner sc=new Scanner(System.in);
//        int range=sc.nextInt();
//        int counter=1;
//        while(counter<=range){
//            System.out.println(counter+" ");
//            counter++;
//        }

        //print sum of first n natural numbers
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int sum=0;
//        int i=1;
//        while (i<=n){
//            sum += i;
//            i++;
//        }
//        System.out.println(sum);



//        for (int i=1; i<=10; i++){
//            System.out.println("Hello world!");
//        }

        //print square pattern
//        for (int i=1; i<=4; i++){
//            System.out.println("****");
//        }

        //print reverse of a number
//        Scanner sc=new Scanner(System.in);
//        int n= sc.nextInt();
//
//        while(n>0){
//            int ld=n%10;
//            System.out.print(ld);
//            n=n/10;
//        }
//        System.out.println();

        //reverse the given number
//        Scanner sc=new Scanner(System.in);
//        int n= sc.nextInt();
//        int rev=0;
//        while(n>0){
//            int ld=n%10;
//            rev=(rev*10)+ld;
//            n=n/10;
//        }
//        System.out.print(rev);


//        int counter=1;
//        do{
//            System.out.println("Hello world");
//            counter++;
//        } while (counter<=10);

//        for(int i=1; i<=5; i++){
//            if(i==3){
//                break;
//            }
//            System.out.println(i);
//        }
//        System.out.println("I am out of the loop");

        //keep entering numbers till user enters a multiple of 10
//        Scanner sc=new Scanner(System.in);
//        do{
//            System.out.println("Enter your number: ");
//            int n= sc.nextInt();
//            if (n % 10 == 0) {
//                break;
//            }
//            System.out.println(n);
//        }while(true);

//        for(int i=1; i<=5; i++){
//            if(i==3){
//                continue;
//            }
//            System.out.println(i);
//        }

        //display all numbers entered by user except multiples of 10
//        Scanner sc=new Scanner(System.in);
//        do{
//            System.out.println("Enter your number: ");
//            int n= sc.nextInt();
//            if (n % 10 == 0) {
//                continue;
//            }
//            System.out.println(n);
//        }while(true);

        //check if a number is prime or not
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if (n==2){
            System.out.println("Prime");
        }else {
            boolean isPrime=true;
            for(int i=2; i<=Math.sqrt(n); i++){
                if(n%i==0){
                    isPrime=false;
                }
            }
            if(isPrime==true){
                System.out.println("Prime");
            }else {
                System.out.println("not Prime");
            }
        }

    }
}
