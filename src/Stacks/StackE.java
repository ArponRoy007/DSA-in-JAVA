package Stacks;

import java.util.Stack;

public class StackE {
    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>(); // Corrected stack type to Character

        for (int i=0; i < str.length(); i++){
            char ch = str.charAt(i);

            // Opening brackets
            if (ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            }
            // Closing brackets
            else {
                if (s.isEmpty()){
                    return false;
                }
                if ((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')){
                    s.pop();
                } else {
                    return false; // Mismatch found
                }
            }
        }

        if (s.isEmpty()){
            return true;
        } else {
            return false;
        }
    }


    public static boolean isDuplicate(String str){
        Stack<Character> s=new Stack<>();

        for (int i=0; i<str.length(); i++){
            char ch=str.charAt(i);
            //opening, operator, operands

            //closing
            if (ch==')'){
                int count=0;
                while (s.peek()!='('){
                    s.pop();
                    count++;
                }
                if (count<1){
                    return true; //duplicate
                } else {
                    s.pop();
                }
            } else {
                //opening
                s.push(ch);
            }
        }
        return false;
    }



    public static void main(String[] args) {
        String str="(({})[])"; //true
        //System.out.println(isValid(str));

        String str2="((a+b))";
        String str3="(a+b)";
        System.out.println(isDuplicate(str2));
        System.out.println(isDuplicate(str3));
    }
}
