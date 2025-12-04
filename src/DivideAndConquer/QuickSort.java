package DivideAndConquer;

public class QuickSort {

    // 🔁 Array print করার জন্য ইউটিলিটি ফাংশন
    public static void printArrr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 🧠 QuickSort ফাংশন → Divide & Conquer
    public static void quickSort(int arr[], int si, int ei) {
        // 🛑 Base case → যদি শুরু > শেষ হয়ে যায়, তাহলে আর কিছু করা লাগবে না
        if (si >= ei) {
            return;
        }

        // 🔻 Divide → Partition করে pivot এর position বের করা হচ্ছে
        int pidx = partition(arr, si, ei);

        // 🔁 Conquer → ডানে ও বামে recursive call
        quickSort(arr, si, pidx - 1);  // বাম পাশে sort
        quickSort(arr, pidx + 1, ei);  // ডান পাশে sort
    }

    // 🔀 Partition ফাংশন → pivot অনুযায়ী elements কে ভাগ করা হচ্ছে
    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];   // শেষের এলিমেন্টকে pivot ধরা হয়েছে
        int i = si - 1;        // i → ছোট এলিমেন্ট রাখার position track করে

        // সব element check করা হচ্ছে pivot এর চেয়ে ছোট কিনা
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // 🔄 Swap → ছোট এলিমেন্টকে সামনে আনা হচ্ছে
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        // ✅ pivot কে তার সঠিক জায়গায় বসানো হচ্ছে
        i++;
        int temp = arr[ei];
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;  // 🔁 এই index থেকেই divide হবে
    }

    // 🟢 main function: সবকিছু টেস্ট করা হচ্ছে
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 8, 2, 5};

        // 🚀 Sorting শুরু
        quickSort(arr, 0, arr.length - 1);

        // ✅ Sorted array print
        printArrr(arr);
    }
}

//Time Complexity:
//Best: O(n log n)
//Average: O(n log n)
//Worst: O(n²)

//Space Complexity:
//Best/Average: O(log n)
//Worst: O(n)
