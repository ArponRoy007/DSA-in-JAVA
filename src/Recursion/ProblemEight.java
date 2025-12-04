package Recursion;

public class ProblemEight {

    // Recursive function to find the last occurrence of a key in the array
    public static int lastOccurence(int arr[], int key, int i) {
        // Base case: if index reaches end of array, key not found
        if (i == arr.length) {
            return -1;
        }

        // Recursive call to check in the rest of the array
        int isFound = lastOccurence(arr, key, i + 1);

        // If key not found in the rest of the array and current element matches the key
        if (isFound == -1 && arr[i] == key) {
            return i; // return current index
        }

        // Else return the index found in further recursion (if any)
        return isFound;
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 7, 5, 3, 5, 2}; // input array
        System.out.println(lastOccurence(arr, 5, 0)); // Output should be 5 (last occurrence of 5)
    }
}
