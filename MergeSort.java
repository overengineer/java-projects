package MergeSort;
import java.util.*;

public class MergeSort {
	private static Comparable a[];
	private static Comparable b[];
	private static void print(){
		int i;
		System.out.print("\n\t[");
     	for(i=0;i<a.length-1;i++){
     		System.out.print(a[i]+", ");
     	}
     	System.out.println(a[i]+"]\n");
	}
	private static void insertionsort(int start, int end)
	{	
		int i,j;
		Comparable tmp;
		for(i=start;i<=end;i++)
		{
			tmp=a[i];
			j=i;
			for(j=i-1;j>=0;j--)
			{
				if(a[j].compareTo(tmp)<=0)
				{
				a[j+1]=tmp;
				break;
				}
				else
				{
				a[j+1]=a[j];
				if(j==0)
				{
					a[j]=tmp;
					break;
				}
				}

			}
		}
	}
	private static void merge(int start,int middle,int end){
		for(int i=0;i<a.length;i++){
     		b[i]=a[i];
		}
		int primer=start,seconder=middle,helper=start;
		while(primer<=end && seconder<=end && helper<=middle){
		a[primer++]=(a[seconder].compareTo(b[helper])<0)?a[seconder++]:b[helper++];
		}
		while(primer<=end && helper<=middle){
		a[primer++]=b[helper++];
		}
		//visualizing process
		System.out.println("start: "+start+" end: "+end);
		print();		
	}
	private static void mergesort(int start, int end){
		//check base case
	if(end>start){
		
	int middle =(int) (end+start)/2;
	mergesort(start,middle);
	//divide
	mergesort(middle+1,end);
	//merge
	merge(start,middle,end);
	}
	else{
	//mergesort and insertionsort hybridized to engage performance
		insertionsort(start,end);
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
		a=new Comparable[20];
		b=new Comparable[20];
		Scanner in = new Scanner(System.in);//to get integer input
	         for(int i=0;i<a.length;i++){
	            System.out.print("Enter integer "+i+": ");
                int input = in.nextInt();
                System.out.println("input : " + input);
                a[i]=new Integer(input);
               
            }

            System.out.println("Entries: ");
         	print();		
         	mergesort(0,a.length-1);
            System.out.println("Sorted: ");
         	print();
         	binarysearch();
             in.close();
             System.exit(0);
        }
}

