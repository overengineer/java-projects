package dataStructuresTest2;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Random;

//multi-threading with BlockingQueue

interface Data {
	public int get();
	public void set(int i);
}
class Producer implements Runnable{
	private final BlockingQueue que;
	private Random rn;
	Producer(BlockingQueue q){
		que=q;
		rn = new Random();
		rn.setSeed(1234);
		}
	public void run(){	//overriding run method from Runnable
		try{
			while(true){
				que.put(produce());
			}
		}catch(InterruptedException ex){
			System.out.print("Error occured:"+ex);
		}
	}
	public Object produce(){
		Data d = new Data() {		//Anonymous Class
				private int i;
				//You cannot define constructor of anon.class
				public int get(){return this.i;}
				public void set(int i){this.i=i;}
		};
		d.set(rn.nextInt());
		return d;
	}
}
class Consumer implements Runnable{
	private final BlockingQueue que;
	Consumer(BlockingQueue q){que=q;}
	public void run(){	//overriding run method from Runnable
	     try {
	         while (true) { consume(que.take()); }
	       } catch (InterruptedException ex) {
	    	   System.out.print("Error occured:"+ex);
	       }
	}
	public void consume(Object ob){
		System.out.print(Thread.currentThread().getName()+"\t"+
		ob.toString()+"\n");
	}
}
public class dataStructuresTest2 {

	public static void main(String args[] ){
		BlockingQueue q=new LinkedBlockingQueue();
		Producer p=new Producer(q);
		Consumer c1=new Consumer(q);
		Consumer c2=new Consumer(q);
	     new Thread(p).start();
	     new Thread(c1).start();
	     new Thread(c2).start();
	}
}
