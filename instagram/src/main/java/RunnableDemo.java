import java.applet.Applet;
import java.awt.Graphics;

public class RunnableDemo extends Applet implements Runnable{
	
	
	Thread t;
	String str;
	
	public void init() {
		str="";
		t=new Thread(this);
		
		t.start();
	}
	
	
	@Override
	public void run() {
		while(true) {
			str=new java.util.Date().toString();
			
			try {
				t.sleep(5000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			repaint();
		}
		
	}
	
	
	public void paint(Graphics g) {
		g.drawString(str, 100, 100);
	}

	
}
