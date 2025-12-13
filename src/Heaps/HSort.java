package Heaps;

public class HSort {

    public static void heapSort(int arr[]) {
        int n = arr.length;

        // Step 1: Build maxHeap
        // লুপটি n/2 - 1 থেকে শুরু করা ভালো, কারণ এটিই শেষ non-leaf node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Push largest at end
        for (int i = n - 1; i > 0; i--) {
            // swap (largest-first with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // বাকী এলিমেন্টগুলোর জন্য আবার heapify কল করা (root বা 0 ইনডেক্স থেকে)
            heapify(arr, i, 0);
        }
    }

    // Heapify function to maintain the heap property
    // n = size of heap, i = root index
    public static void heapify(int arr[], int n, int i) {
        int largest = i; // ধরে নিচ্ছি রুট-ই সবচেয়ে বড়
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index

        // যদি বাম পাশের চাইল্ড রুটের চেয়ে বড় হয়
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // যদি ডান পাশের চাইল্ড বর্তমান largest-এর চেয়ে বড় হয়
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // যদি largest পরিবর্তন হয় (অর্থাৎ রুট সবচেয়ে বড় না হয়)
        if (largest != i) {
            // Swap
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 3};

        // Sorting function call
        heapSort(arr);

        // Print the sorted array
        System.out.println("Sorted Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}