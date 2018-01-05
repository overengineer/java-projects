package Multisort;

import java.io.IOException;
import java.util.*;
public class Multisort {
	public static class ShellSort {
		public ShellSort(Comparable array[]){
			a=array;
		}
		private  Comparable a[];
		public  void print(){
			int i;
			System.out.print("\n\t[");
	     	for(i=0;i<a.length-1;i++){
	     		System.out.print(a[i].toString()+", ");
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
	public static class ID extends HashMap<String,Comparable> implements Comparable{
		private String sort_parameter;
		public ID( String sort_parameter){
			this.sort_parameter=sort_parameter;
		}
		public void set(String name,String surname, Integer number, Calendar date){
			this.put("name",new String(name));
			this.put("surname",new String(surname));
			this.put("number",new Integer(number));
			this.put("date",(Comparable) date.getTime());
		}
		private static final long serialVersionUID = 1L;
		
		public int compareTo( Object t ){
			if(t==null){
				 System.out.print("null argument");
				 return 1;
			}else if(t.getClass().equals(this.getClass())){
				ID id=(ID) t;
				return this.compareTo(id.get(sort_parameter));
			}else{
				return this.get(sort_parameter).compareTo(t);
			}
		}
	}

	private static String sort_parameter;
	public static void main(String args[]) throws IOException{
		 ShellSort shellsort;
		ID a[];
		a= new ID[3];
		Scanner in = new Scanner(System.in);//to get integer input
		shellsort = new ShellSort(a);
			for(int i=0;i<a.length;i++){
				a[i]= new ID(sort_parameter);
	        	System.out.println("Person "+ i);
	            System.out.print("Enter name "+i+": ");
	            String name=in.next();
	            System.out.print("Enter surname "+i+": ");
	            String surname=in.next();
	            System.out.print("Enter number "+i+": ");
	            Integer number=in.nextInt(); 
	            Calendar date=Calendar.getInstance();
	            System.out.print("Enter year "+i+": ");
	            int year=in.nextInt();
	            System.out.print("Enter month "+i+": ");
	            int month=in.nextInt();
	            System.out.print("Enter day "+i+": ");
	            int day=in.nextInt();
	            date.set(year,month,day);
	            a[i].set(name, surname, number,date);
	        }		
            System.out.println("Entries: ");
         	shellsort.print();
         	while(true){
         	System.out.println("Sort by name or surname or number or date? enter 'quit' to terminate.");
         	sort_parameter=in.next();
         	if(sort_parameter.equals("quit")){
                in.close();
                System.exit(0);
         	}else if(sort_parameter==null){
                System.out.println("null parameter");
                in.close();
                System.exit(0);
         	}
         	shellsort.shellsort();
            System.out.println("Sorted: ");
         	shellsort.print();
         	}
        }
}
