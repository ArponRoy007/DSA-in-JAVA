package ArraysPI;
import java.util.*;
public class ArraysPart1 {
    public static void update(int marks[]){
        for (int i=0; i<marks.length; i++){
            marks[i]=marks[i]+1;
        }
    }

    public static int getLargest(int nums[]){
        int largest=Integer.MIN_VALUE; //-infinity
        int smallest=Integer.MAX_VALUE;

        for (int i=0; i<nums.length; i++){
            if (largest<nums[i]){
                largest=nums[i];
            }
            if (smallest > nums[i]){
                smallest=nums[i];
            }
        }
        System.out.println("Smallest value is: "+smallest);
        return largest;
    }

    public static void main(String[] args) {
        //creation
        int marks[]=new int[50];
//        int numbers[]={1, 2, 3};

        //input
//        Scanner sc=new Scanner(System.in);
//        marks[0]=sc.nextInt();
//        marks[1]=sc.nextInt();
//        marks[2]=sc.nextInt();
//        System.out.println("Phy: "+ marks[0]);
//        System.out.println("Che: "+ marks[1]);
//        System.out.println("Bio: "+ marks[2]);

        //update
//        marks[2]=100;
//        System.out.println("Bio: "+ marks[2]);

//        int percentage=(marks[0]+marks[1]+marks[2])/3;
//        System.out.println("Percentage= "+percentage+"%");

//        System.out.println("Length of array: "+marks.length);

        //passing arrays as argument
//        int marks[]={95,96,93};
//        update(marks);

        //print our marks - by reference
//        for (int i=0; i<marks.length; i++){
//            System.out.print(marks[i]+" ");
//        }
//        System.out.println();


        //largest number
        int nums[]={1, 2, 6, 3, 5};
        System.out.println("Largest value is: "+ getLargest(nums));
    }
}
