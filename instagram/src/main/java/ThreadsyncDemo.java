
class MyThread extends Thread{
	
	MyThread(String str){
		super(str);
	}
	
	String message[]= {"I","LOVE","JAVA","!"};
	
	public void run() {
		RunMyThread.executeMyThread(message,getName());
	}
	
}
//Hashtable is thread safe class
//HashMap is non thread safe
class RunMyThread{
	public static void executeMyThread(String msg[],String name) {
		for(int i=0;i<msg.length;i++) {
			
			try {
				Thread.sleep(2000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			System.out.println(name+"   "+msg[i]);
		}
	}
}

executor, lock, scheduler

public class ThreadsyncDemo {

	public static void main(String[] args) {
		MyThread t1=new MyThread("Thread 1 : ");
		MyThread t2=new MyThread("Thread 2 : ");
		MyThread t3=new MyThread("Thread 3 : ");
		MyThread t4=new MyThread("Thread 4 : ");
		
		MyThread t5=new MyThread("Thread 5 : ");
		MyThread t6=new MyThread("Thread 6 : ");
		
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();

	}

}

//here t1 and t2 will be thread because MyThread class is child of Thread class