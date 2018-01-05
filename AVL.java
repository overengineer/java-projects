package AVL;

import java.util.Vector;

public class AVL {
	public AVL(){
		locations= new Vector<Object>();
		root=null;
		target=null;
	}
private class Node extends Object{
	Node(Comparable value){
		this.element=value;
		this.height=0;
		this.right=null;
		this.left=null;
	}
	public Comparable element;
	public int height;
	public Node right; 
	public Node left;
	public void update(){
		this.height= 1+max(this.left==null?-1:this.left.height,this.right==null?-1:this.right.height);
	}
	private Node rotateleft(){
		System.out.println("rotateleft");
		Node temp=this.right;
		this.right=temp.left;
		temp.left=this;
		this.update();
		temp.update();
		return temp;
	}
	private Node rotateright(){
		System.out.println("rotateright");
		Node temp=this.left;
		this.left=temp.right;
		temp.right=this;
		this.update();
		temp.update();
		return temp;
	}
	private Node rotaterightleft(){
		System.out.println("rotaterightleft");
		Node near=this.right;
		Node far=near.left;
		near.left=far.right;
		this.right=far.left;
		far.left=this;
		far.right=near;
		return far;
	}
	private Node rotateleftright(){
		System.out.println("rotateleftright");
		Node near=this.left;
		Node far=near.right;
		near.right=far.left;
		this.left=far.right;
		far.right=this;
		far.left=near;
		return far;
	}
	public Node balance(){
		if(balancefactor(this)>1){
			if(balancefactor(this.right)>0)
			return this.rotateleft();
			else
			return this.rotaterightleft();		
		}else if(balancefactor(this)<-1){
			if(balancefactor(this.left)<0)
			return this.rotateright();
			else
			return this.rotateleftright();
		}
		else return this;
	}
}
private  Node root;
public  void add(int value){
	Node node=new Node(value);
	if(root==null){
		root=node;
	}else{
		root=insert(node,root);
	}
}
private  int max(int a,int b){
	return (a>b)?a:b;
}
private  int balancefactor(Node node){
	if(node==null)
	return 0;
	else
	return (node.right==null?-1:node.right.height)-(node.left==null?-1:node.left.height);
}
//a non-null node should be passed, returns it's height
private  Node insert(Node node,Node start){
	if(start.element.compareTo(node.element)>0){
		if(start.left==null){
			start.left=node;
		}else{
			start.left=insert(node,start.left);
		}
	}else{
		if(start.right==null){
			start.right=node;
		}else{
			start.right=insert(node,start.right);
		}
	}
	start.update();
	return start.balance();
}
public void print(){
	print(root,0);
}
private void print(Node cur,int i){
		int j;
		if( cur!=null ){
		System.out.print( cur.element.toString()+"("+cur.height+")"+balancefactor(cur) +"-->");
		print( cur.right, i+1 );
		j=i;
		while( (j--)>0){System.out.print("        ");	}
		System.out.print("|\n");
		j=i;
		while( (j--)>0){System.out.print("        ");	}
		System.out.print("-->");
		print( cur.left, i+1 );
		}
		else 
		{
			System.out.print("null\n");
		}	
	}
public Vector<Object> locations;
public  Comparable target;
public  void depth_first_search(Comparable i){
	target=i;
	depth_first_search(root);
}
private  void depth_first_search(Node cur){
	if(cur!=null){
	if(cur.element.equals(target)){
		locations.add(cur);
	}
	depth_first_search(cur.right);
	depth_first_search(cur.left);	
	}
}

}

