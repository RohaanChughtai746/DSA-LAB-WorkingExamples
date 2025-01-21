/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab10;

/**
 *
 * @author HP
 */
class AVLTree {
    static class TreeNode {
        int key, height;
        TreeNode left, right;
        TreeNode(int key) {
            this.key = key;
            this.height = 1;
        }
    }
    private int height(TreeNode node) {
        return (node == null) ? 0 : node.height;
    }
    private int getBalance(TreeNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }
    private TreeNode rotateRight(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x; 
    }
    private TreeNode rotateLeft(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }
    private TreeNode getMinValueNode(TreeNode node) {
        TreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    public TreeNode delete(TreeNode root, int key) {
        if (root == null) return root;
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            if ((root.left == null) || (root.right == null)) {
                TreeNode temp = (root.left != null) ? root.left : root.right;

                if (temp == null) { 
                    root = null;
                } else { 
                    root = temp;
                }
            } else {
                TreeNode temp = getMinValueNode(root.right);
                root.key = temp.key;

                root.right = delete(root.right, temp.key);
            }
        }
        if (root == null) return root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rotateRight(root);
        }
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0) {
            return rotateLeft(root);
        }
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }
    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        TreeNode root = null;
        int[] keys = {9, 5, 10, 0, 6, 11, -1, 1, 2};
        for (int key : keys) {
            root = tree.insert(root, key);
        }
        System.out.print("In-order Traversal before Deletion: ");
        tree.inorder(root);
        System.out.println();
        root = tree.delete(root, 10);
        System.out.print("In-order Traversal after Deleting 10: ");
        tree.inorder(root);
        System.out.println();

        root = tree.delete(root, 5);
        System.out.print("In-order Traversal after Deleting 5: ");
        tree.inorder(root);
        System.out.println();

        root = tree.delete(root, 9);
        System.out.print("In-order Traversal after Deleting 9: ");
        tree.inorder(root);
        System.out.println();
    }
    public TreeNode insert(TreeNode root, int key) {
        if (root == null) return new TreeNode(key);
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        } else {
            return root; 
        }
        root.height = 1 + Math.max(height(root.left), height(root.right));
        int balance = getBalance(root);
        if (balance > 1 && key < root.left.key) {
            return rotateRight(root);
        }
        if (balance < -1 && key > root.right.key) {
            return rotateLeft(root);
        }
        if (balance > 1 && key > root.left.key) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }
        if (balance < -1 && key < root.right.key) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }
        return root;
    }
}

