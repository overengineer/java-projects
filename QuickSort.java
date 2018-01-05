package QuickSort;
import java.util.*;

public class QuickSort {
	private static Comparable a[];
	private static void print(){
		int i;
		System.out.print("\n\t[");
     	for(i=0;i<a.length-1;i++){
     		System.out.print(a[i]+", ");
     	}
     	System.out.println(a[i]+"]\n");
	}
private static void swap( int key1,int key2){
	Comparable tmp=a[key1];
	a[key1]=a[key2];
	a[key2]=tmp;
}
private static void sort( int first, int last ){

	int L=first;
	//set pivot as last element
	int P=last;
	int R=last-1;

//while arrows don't meet
while(R>L){
//Shifting arrows
while((L<R)&&a[L].compareTo(a[P])<=0){
L++;
}
while((L<R)&&(a[R].compareTo(a[P])>=0)){
R--;
}		
//Visualizing the process
					char flag;
					int i;
					for(i=first; i<=last; i++){
						 System.out.print(i+"\t");
						}
					System.out.print("R="+R+" L="+L+" P="+P);
					System.out.println("");
						for(i=first; i<=last; i++){
							 System.out.print(a[i]+"\t");
						}
						 System.out.println("");
						for(i=first; i<=last; i++){
						if(i==L)
						flag='L';
						else if(i==R)
						flag='R';
						else if(i==P)
						flag='P';
						else
						flag=' ';
						 System.out.print(flag+"\t");
						}
						 System.out.println("\n");
	//swap elements where arrows on
	if(!a[R].equals(a[L]))
		swap(R,L);
	}
	//swap pivot
	if(a[R].compareTo(a[P])<0)
	swap(P,R);
	//if not sorted
	if( R<P)
	{
		//check base case
		if(R>first)
		sort(first,R);
		//check base case
		if(R+1<last)
		sort(R+1,last);
	}
}
public static void binarysearch() {
	Scanner in = new Scanner(System.in);//to get integer input
    System.out.print("Enter integer to be found: ");
    Comparable target = new Integer(in.nextInt());
    int i=(int)a.length/2;
    int j=(int)i/2;
    while(true){
    	System.out.println(i);
    	if(a[i].equals(target)){
    	 System.out.print("Target found in location: "+i);
    	 in.close();
         return;
    	}
    	i+=(a[i].compareTo(target)<0)?j:-j;
    	if(j==0){
    		for(;i>=0&&i<a.length&& !a[i].equals(target);i+=(a[i].compareTo(target)<0)?1:-1);	//in edge locations target linearly searched since array is not exact power of two
    		if(!a[i].equals(target)){
        	 System.out.print("Target not found. ");  
          	 in.close();
          	return;
    		}
       	}
    	j=(int)j/2;
    	
    }
   }
public static void main(String args[]) {
			a=new Integer[10];
			Scanner in = new Scanner(System.in);//to get integer input
    	         for(int i=0;i<a.length;i++){
    	            System.out.print("Enter integer "+i+": ");
	                int input = in.nextInt();
	                System.out.println("input : " + input);
	                a[i]=input;
	               
	            }

                System.out.println("Entries: ");
             	print();
             	sort(0,a.length-1);
                System.out.println("Sorted: ");
             	print();
             	binarysearch();
                 in.close();
                 System.exit(0);
	        }
	}



