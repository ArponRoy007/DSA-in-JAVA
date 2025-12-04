package Recursion;
//WAF to find the first occurence of an element in an array
public class ProblemSeven {
    public static int firstOccurence(int arr[], int key, int i){
        if (i== arr.length){
            return -1;
        }
        if (arr[i]==key){
            return i;
        }
        return firstOccurence(arr, key, i+1);
    }

    public static void main(String[] args) {
        int arr[]={1,4,7,5,3,5,2};
        System.out.println(firstOccurence(arr, 5, 0));
    }
}
