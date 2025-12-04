package ArraysPI;

public class BinarrySearch {
    public static int binarySearch(int nums[], int key){
        int start=0, end=nums.length-1;

        while (start<=end){
            int mid=(start+end)/2;
            
            //comparisons
            if (nums[mid]==key){
                return mid;
            } else if (nums[mid]<key) { //right
                start=mid+1;
            } else { //left
                end=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // Create an array
        int nums[] = {2, 4, 6, 8, 10, 12, 14, 16};
        // The value we are searching for
        int key = 10;
        System.out.println("Index for key is: "+binarySearch(nums,key));
    }
}
