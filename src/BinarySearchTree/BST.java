package BinarySearchTree;

import BinarySearch.TreeNode;

public class BST {

    public TreeNode findSuccessor(TreeNode root, TreeNode p){
        TreeNode successor = null;
        if (p.right != null){       //the leftmost node of its right subtree
            successor = p.right;
            while(successor.left != null){
                successor = successor.left;
            }

            return successor;
        }

        while(root != null) {   //find the p's first parent whose leftchild is the parent of p
            if (p.val > root.val){  //p is on the right subtree of root
                root = root.right;
            }else if (p.val < root.val){
                successor = root;
                root = root.left;
            }else{

            }
        }

        return successor;
    }

    public TreeNode findPredecessor(TreeNode root){

    }
}
