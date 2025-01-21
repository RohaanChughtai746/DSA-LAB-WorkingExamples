/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB1;

/**
 *
 * @author HP
 */
public class MatrixSum {
    public static void main(String[] args) {
        int[][] matrix1 = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        int[][] matrix2 = {
            {7,8,9},
            {4,5,6}, 
            {1,2,3}
        };
        int[][] result = new int[3][3];
        for(int i=0;i<3 ; i++) {
            for(int j =0; j<3; j++){
                result[i][j]=matrix1[i][j]+matrix2[i][j];
            }
        }
         System.out.println("Sum of the two matrices:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    }

