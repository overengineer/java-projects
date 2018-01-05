package dataStructuresTest1;
import java.util.*;
import java.io.*;

public class dataStructuresTest1 {
	public static void main(String args[]) {
	      Enumeration<String> days;
	      Vector<String> dayNames = new Vector<String>();
	      dayNames.add("Sunday");
	      dayNames.add("Monday");
	      dayNames.add("Tuesday");
	      dayNames.add("Wednesday");
	      dayNames.add("Thursday");
	      dayNames.add("Friday");
	      dayNames.add("Saturday");
	      days = dayNames.elements();
	      
	      while (days.hasMoreElements()) {
	         System.out.println(days.nextElement()); 
	      }
	      
	    		 BufferedReader br = null;

	    	        try {

	    	            // Refer to this http://www.mkyong.com/java/how-to-read-input-from-console-java/
	    	            // for JDK 1.6, please use java.io.Console class to read system input.
	    	            br = new BufferedReader(new InputStreamReader(System.in));
	                    LinkedList<String> entries = new LinkedList<String>();
	                    
	    	            while (true) {

	    	                System.out.print("Enter something : ");
	    	                String input = br.readLine();

	    	                if ("q".equals(input)) {
	    	                	System.out.println("entries: "+ entries.toString());
	    	                    System.out.println("Exit!");
	    	                    System.exit(0);
	    	                }

	    	                System.out.println("input : " + input);
	    	                System.out.println("-----------\n");
	    	                entries.add(input);
	    	               
	    	            }

	    	        } catch (IOException e) {
	    	            e.printStackTrace();
	    	        } finally {
	    	            if (br != null) {
	    	                try {
	    	                    br.close();
	    	                } catch (IOException e) {
	    	                    e.printStackTrace();
	    	                }
	    	            }
	    	        }

	    	}
	    }


