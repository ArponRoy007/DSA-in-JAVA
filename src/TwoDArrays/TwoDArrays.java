package TwoDArrays;

import java.util.Scanner;

public class TwoDArrays {
    public static boolean search(int[][] matrix, int key){
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==key){
                    System.out.println("Found at cell("+i+","+j+")");
                    return true;
                }
            }
        }
        System.out.println("Key not found");
        return false;
    }

    public static int findMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    public static int findMin(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int matrix[][]=new int[3][3];
        int n=matrix.length, m=matrix[0].length;

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the elements of the 3x3 matrix:");
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                matrix[i][j]= sc.nextInt();
            }
        }

        //output
        System.out.println("The matrix is:");
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        search(matrix, 5);

        // Call the max and min functions and display results
        int maxValue = findMax(matrix);
        int minValue = findMin(matrix);

        System.out.println("Maximum value in the matrix: " + maxValue);
        System.out.println("Minimum value in the matrix: " + minValue);
    }
}