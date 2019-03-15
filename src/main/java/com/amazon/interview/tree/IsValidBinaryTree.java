package com.amazon.interview.tree;

public class IsValidBinaryTree {
	
	private static Node root;

	public static void main(String args[]) 
    { 
		IsValidBinaryTree tree = new IsValidBinaryTree(); 
        tree.root = new Node(4); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(5); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(3); 

        if (tree.isBST()) 
            System.out.println("IS BST"); 
        else
            System.out.println("Not a BST"); 
    } 
	
	
	private static boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean isBSTUtil(Node node, int min, int max) {
		if(node == null) return true;
		
		if(node.data > max || node.data < min) return false;
		
		return (isBSTUtil(node.left, min, node.data -1) && isBSTUtil(node.right, node.data+ 1, max));
	}
	

	public static class Node{
		private int data ;
		private Node left, right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	
}
