/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice;

/**
 *
 * @author HP
 */
import java.io.*;
public class insertAnyPosition {
  static void insertElement(int arr[], int n , int x , int position)  {
      for(int i = n-1; i>=position; i--) 
      arr[i+1]=arr[i] ;
      arr[position]=x;
      
  }
    public static void main(String[] args) {
      int []arr = new int[20];
        arr[0]=12;
        arr[1]=30;
        arr[2]=55;
        arr[3]=66;
        arr[4]=22;  
        int n=5;
        int x=1, position=2;
        System.out.println("before insertion");
        for(int i=0;i<n;i++) 
            System.out.println(arr[i] + " ");
        insertElement(arr,n,x ,position);
        n +=1;
        System.out.println("after insertion");
        for(int i=0;i<n;i++) 
            System.out.println(arr[i] + " ");
}
}
