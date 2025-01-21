/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB1;

/**
 *
 * @author HP
 */
public class SumOfFirst10NaturalNumbers {
    public static void main(String[] args) {
    int sum = 0;
    int n = 10;
    for (int i = 1; i<=10 ; i++) {
        sum +=i;
    }
    System.out.println("Sum of first " + n + " natural numbers is " + sum);
}
}
