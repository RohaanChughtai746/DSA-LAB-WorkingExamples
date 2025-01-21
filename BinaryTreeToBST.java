/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB9;

/**
 *
 * @author HP
 */
import java.util.ArrayList;
import java.util.Collections;

class BinaryTreeToBST {
    static class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    public static void storeInOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        storeInOrder(root.left, list);
        list.add(root.value);
        storeInOrder(root.right, list);
    }
    public static void arrayToBST(TreeNode root, ArrayList<Integer> list, int[] index) {
        if (root == null) return;
        arrayToBST(root.left, list, index);
        root.value = list.get(index[0]);
        index[0]++;
        arrayToBST(root.right, list, index);
    }
    public static TreeNode binaryTreeToBST(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<>();
        storeInOrder(root, values); 
        Collections.sort(values); 
        arrayToBST(root, values, new int[]{0}); 
        return root;
    }
    public static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.value + " ");
        inorderTraversal(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(30);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(20);
        root.right.right = new TreeNode(5);
        System.out.print("Original Binary Tree In-order: ");
        inorderTraversal(root);
        System.out.println();
        TreeNode bstRoot = binaryTreeToBST(root);
        System.out.print("Converted BST In-order: ");
        inorderTraversal(bstRoot);
    }
}
