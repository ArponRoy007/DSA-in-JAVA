package ArraysPII;

public class MaxSubarraySum {
    //brute force
    public static void maxSubSum(int nums[]){
        int currSum=0;
        int maxSum= Integer.MIN_VALUE;

        for (int i=0; i<nums.length; i++){
            int start=i;
            for (int j=i; j<nums.length; j++){
                int end=j;
                currSum=0;
                for (int k=start; k<=end; k++){
                    currSum += nums[k];
                }
                System.out.print(currSum+" ");
                if (maxSum<currSum){
                    maxSum=currSum;
                }
            }
        }
        System.out.println("Max Sum: "+maxSum);
    }

    //prefix sum
    public static void usePrefixSum(int numbers[]){
        int currSum=0;
        int maxSum= Integer.MIN_VALUE;
        int prefix[]=new int[numbers.length];

        prefix[0]=numbers[0];
        //calculate prefix sum
        for (int i=1; i<prefix.length; i++){
            prefix[i]=prefix[i-1]+numbers[i];
        }

        for (int i=0; i<numbers.length; i++){
            int start=i;
            for (int j=i; j<numbers.length; j++){
                int end=j;
                currSum= start==0? prefix[end] :  prefix[end]-prefix[start-1];

                if (maxSum<currSum){
                    maxSum=currSum;
                }
            }
        }
        System.out.println("Max sum: "+maxSum);
    }

    //kadane's algorithm
    public static void useKadaneAlgorithm(int numb[]){
        int ms=Integer.MIN_VALUE;
        int cs=0;

        boolean allNegative = true;
        int maxNegative = Integer.MIN_VALUE;

        for (int i=0; i<numb.length; i++){
            cs=cs+numb[i];
            // Check if at least one element is non-negative
            if (numb[i] >= 0) {
                allNegative = false;
            }

            // Track the largest negative number (for all-negative case)
            if (numb[i] > maxNegative) {
                maxNegative = numb[i];
            }
            if(cs<0){
                cs=0;
            }
            ms=Math.max(cs,ms);
        }
        // If all elements are negative, use the maximum (least negative) value
        if (allNegative) {
            ms = maxNegative;
        }
        // If all elements are negative, use the maximum (least negative) value
        if (allNegative) {
            ms = maxNegative;
        }
        System.out.println("Our maximum sub array sum is: "+ms);
    }

    public static void main(String[] args) {
//        int nums[]={2, 4, 6, 8,10};
//        maxSubSum(nums);

//        int numbers[]={1, -2, 6, -1, 3};
//        usePrefixSum(numbers);

        int numb[]={-2, -3, 4, -1, -2, 1, 5, -3};
        useKadaneAlgorithm(numb);
    }
}

//tc=O(n3) [worst]

//tc=O(n2) [optimize]

//tc=O(n) [Best]