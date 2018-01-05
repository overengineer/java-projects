package ShellSort;

import java.util.Scanner;


public class ShellSort {
	public ShellSort(Comparable array[]){
		a=array;
	}
	private  Comparable a[];
	public  void print(){
		int i;
		System.out.print("\n\t[");
     	for(i=0;i<a.length-1;i++){
     		System.out.print(a[i]+", ");
     	}
     	System.out.println(a[i]+"]\n");
	}
	private  void insertionsort(int start, int end)
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
	private void swap(int key1,int key2){
		Comparable tmp=a[key1];
		a[key1]=a[key2];
		a[key2]=tmp;
	}
	public void shellsort(){
		for(int gap=(int)Math.floor(a.length/2);gap>1;gap=(int)Math.floor(gap/2)){
			for(int i=gap;i<a.length;i++){
				if(a[i].compareTo(a[i-gap])<0){
					swap(i,i-gap);
					print();
				}
			}
		}
		insertionsort(0,a.length-1);
	}
	//böyle olmiycak tabiki
	public void binarysearch() {
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
}

