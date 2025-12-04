package Stacks;

import java.util.Stack;

public class StackC {
    public static void stockSpan(int stocks[], int span[]){
        // একটি Stack তৈরি করা হয়েছে যা স্টকের index সংরক্ষণ করবে
        // A stack is created to store the stock indices
        Stack<Integer> s = new Stack<>();

        // প্রথম দিনের স্প্যান সবসময় ১ হবে, কারণ তার আগে কোনো দিন নেই
        // The span of the first day is always 1, as there are no days before it
        span[0] = 1;

        // প্রথম দিনের index টি stack-এ push করা হয়েছে
        // The index of the first day is pushed onto the stack
        s.push(0);

        // দ্বিতীয় দিন থেকে loop শুরু হবে, কারণ প্রথম দিনটি ইতিমধ্যে handle করা হয়েছে
        // The loop will start from the second day, as the first day has already been handled
        for (int i = 1; i < stocks.length; i++){
            // বর্তমান দিনের মূল্য
            // The current day's price
            int currPrice = stocks[i];

            // Stack যতক্ষণ খালি না হয় এবং বর্তমান মূল্য stack-এর উপরের মূল্যের থেকে বেশি হয়
            // While the stack is not empty and the current price is greater than the price at the top of the stack
            while (!s.isEmpty() && currPrice >= stocks[s.peek()]){
                // Stack থেকে index pop করা হয়, কারণ তারা আর আমাদের প্রয়োজন নেই
                // Indices are popped from the stack because we no longer need them
                s.pop();
            }

            // যদি stack খালি হয়ে যায়, তার মানে বর্তমান মূল্য আগের সব দিনের থেকে বেশি
            // If the stack becomes empty, it means the current price is greater than all previous days
            if (s.isEmpty()){
                // স্প্যান হবে বর্তমান দিনের index + ১
                // The span will be the current day's index + 1
                span[i] = i + 1;
            } else {
                // Stack এর উপরে থাকা index টি হল আগের সর্বোচ্চ মূল্যের দিন
                // The index at the top of the stack is the day with the previous highest price
                int prevHigh = s.peek();
                // স্প্যান হবে বর্তমান দিনের index এবং আগের সর্বোচ্চ মূল্যের দিনের index এর পার্থক্য
                // The span will be the difference between the current day's index and the previous highest day's index
                span[i] = i - prevHigh;
            }

            // বর্তমান দিনের index টি stack-এ push করা হয়েছে
            // The index of the current day is pushed onto the stack
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];

        // stockSpan function কে কল করা হচ্ছে
        // Calling the stockSpan function
        stockSpan(stocks, span);

        // ফলাফল print করা হচ্ছে
        // Printing the result
        for (int i = 0; i < span.length; i++){
            System.out.print(span[i] + " ");
        }
    }
}