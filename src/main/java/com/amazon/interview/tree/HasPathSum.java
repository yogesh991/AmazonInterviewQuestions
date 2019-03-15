package com.amazon.interview.tree;

public class HasPathSum {

	static class Node{
		private Node left, right;
		private  int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static Node root;
	
	public static void main(String args[])  
    { 
        int sum = 21; 
          
        /* Constructed binary tree is 
              10 
             /  \ 
           8     2 
          / \   / 
         3   5 2 
        */
        HasPathSum tree = new HasPathSum(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(2); 
        tree.root.left.left = new Node(3); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(2); 
   
        if (tree.hasPathSum(root, sum)) 
            System.out.println("There is a root to leaf path with sum " + sum); 
        else
            System.out.println("There is no root to leaf path with sum " + sum); 
    } 
	
	
	private static boolean hasPathSum(Node temp, int sum) {
		
		if(temp == null) return (sum == 0);
		else {
			boolean ans = false;
			
			int subSum =sum - temp.data;
			
			if(sum ==0 && temp.left == null && temp.right == null) 
				return true;
			
			if(temp.left != null)
				ans = ans || hasPathSum(temp.left, subSum);
			
			if(temp.right != null)
				ans = ans || hasPathSum(temp.right, subSum);
			
			return ans;
		}
		
	}
	
}
