/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practice;

/**
 *
 * @author HP
 */
class UnsortedArray {
    static int findElement(int arr[] ,int n, int key) {
    for(int i=0; i<n;i++)
        if(arr[i]==key)
        return i;
        return -1;
      
} 
    public static void main(String[] args) {
        int arr[]={12,45,33,77,99};
        int n=arr.length;
        int key = 45;
        int position= findElement(arr,n,key);
        if(position==-1) 
            System.out.println("element not found");
        else
            System.out.println("element found at the position:" +(position+1));
            
    }
}