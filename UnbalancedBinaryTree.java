package UnbalancedBinaryTree;

import java.util.Scanner;
import java.util.Vector;

public class UnbalancedBinaryTree {
private static class Node extends Object{
	public int key;
	public Node right;
	public Node left;
}
private static Node root;
public static void add(int value){
	Node node=new Node();
	node.key=value;
	node.right=null;
	node.left=null;
	if(root==null){
		root=node;
	}else{
		insert(node,root);
	}
}
private static void insert(Node node,Node start){
	if(start.key>node.key){
		if(start.left==null){
			start.left=node;
		}else{
			insert(node,start.left);
		}
	}else{
		if(start.right==null){
			start.right=node;
		}else{
			insert(node,start.right);
		}
	}
}
public static void print(Node cur,int i){
		int j;
		if( cur!=null ){
		System.out.print( cur.key +"-->");
		print( cur.right, i+1 );
		j=i;
		while( (j--)>0){System.out.print("    ");	}
		System.out.print("|\n");
		j=i;
		while( (j--)>0){System.out.print("    ");	}
		System.out.print("-->");
		print( cur.left, i+1 );
		}
		else 
		{
			System.out.print("null\n");
		}	
	}
private static Vector<Node> locations;
private static int target;
public static void depth_first_search(Node cur){
	if(cur!=null){
	System.out.println(cur.key);
	if(cur.key==target){
		locations.add(cur);
	}
	depth_first_search(cur.right);
	depth_first_search(cur.left);	
	}
}
public static void main( String args[] ){
	locations = new Vector<Node>();
	Scanner in = new Scanner(System.in);//to get integer input
	int i=1;
    while(true){
       System.out.print("Enter integer "+i+": ");
       i++;
       int input = in.nextInt();
       System.out.println("input : " + input);
       add(input);
       print(root,0);
      if(input<0){
        System.out.print("Enter integer to be found: ");
        target = in.nextInt();
        depth_first_search(root);
        System.out.println("results:\n"+locations.toString());
    	    in.close();
    	    System.exit(0);
      }
   }


}
}
