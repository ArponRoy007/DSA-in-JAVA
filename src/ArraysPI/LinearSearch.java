package ArraysPI;

public class LinearSearch {
    // This method does linear search
    public static int linearSearch(int[] num, int key){
        // Loop through the array from start to end
        for (int i = 0; i < num.length; i++){
            // Check if the current element is equal to the key
            if (num[i] == key){
                return i;  // If found, return the index
            }
        }
        return -1;  // If not found after checking all elements
    }

    public static void main(String[] args) {
        // Create an array
        int num[] = {2, 4, 6, 8, 10, 12, 14, 16};

        // The value we are searching for
        int key = 10;

        // Call the linearSearch function and store the result
        int index = linearSearch(num, key);

        // Check if the key was found or not
        if (index == -1){
            System.out.println("Not found"); // Key not found in the array
        } else {
            System.out.println("Key is at index: " + index); // Key found, print index
        }
    }
}
