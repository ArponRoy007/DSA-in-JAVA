package Strings;

import java.util.*;

public class ExampleOfStrings {
    public static void printLetters(String str){
        for (int i=0;i<str.length();i++){
            System.out.print(str.charAt(i)+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        char arr[]={'a','b','c','d'};
        String str="abcd";
        String str2=new String("xyz");

        //Strings are IMMUTABLE

        Scanner sc=new Scanner(System.in);

        String name;
        String name2;
       name=sc.next(); // just a word
        System.out.println(name);
        name2=sc.nextLine(); //full line
        System.out.println(name2);

        String fullName="Arpon Roy";
        System.out.println(fullName.length());

        //concatenation
        String firstName="Arpon";
        String lastName="Roy";
        String fulName=firstName+" "+lastName;
//        System.out.println(fulName);
//        System.out.println(fulName.charAt(0));
        printLetters(fulName);
    }
}
