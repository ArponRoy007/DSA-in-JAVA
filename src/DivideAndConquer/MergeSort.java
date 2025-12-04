package DivideAndConquer;

public class MergeSort {

    // 🔁 Array print করার জন্য ইউটিলিটি ফাংশন
    public static void printArr(int arr[]){
        for (int i=0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    // 🔄 Recursive Merge Sort function
    public static void mergeSort(int arr[], int si, int ei){
        // ✅ Base case: একটাই এলিমেন্ট থাকলে আর ডিভাইড করার দরকার নেই
        if (si >= ei){
            return;
        }

        // 🟡 Divide: মাঝখান থেকে ভাগ করছি
        int mid = si + (ei - si) / 2;

        // 🔵 Conquer: দুইটা ভাগে রিকার্সিভলি mergeSort কল করছি
        mergeSort(arr, si, mid);       // বাম দিক (Left Part)
        mergeSort(arr, mid + 1, ei);   // ডান দিক (Right Part)

        // 🟢 Merge: Sorted দুইটা পার্ট মিক্স করছি
        merge(arr, si, mid, ei);
    }

    // ✅ দুইটা sorted অংশ merge করার ফাংশন
    public static void merge(int arr[], int si, int mid, int ei){
        int temp[] = new int[ei - si + 1];
        int i = si;       // Left part iterator
        int j = mid + 1;  // Right part iterator
        int k = 0;        // Temp array iterator

        // 🔄 দুইটা পার্ট compare করে ছোটটা temp[] তে রাখছি
        while (i <= mid && j <= ei){
            if (arr[i] < arr[j]){
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // যদি বাকি থাকে বামদিকের
        while (i <= mid){
            temp[k++] = arr[i++];
        }

        // যদি বাকি থাকে ডানদিকের
        while (j <= ei){
            temp[k++] = arr[j++];
        }

        // 🔁 temp এর ডেটা মূল arr তে কপি করছি
        for (int m = 0; m < temp.length; m++){
            arr[si + m] = temp[m];
        }
    }

    // 🟢 main function: test করা হচ্ছে
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};

        mergeSort(arr, 0, arr.length - 1);

        printArr(arr);
    }
}
//tc=O(nlogn) sc=O(n)