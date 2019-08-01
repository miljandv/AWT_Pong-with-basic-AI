package pong;

import java.awt.Canvas;
import java.awt.Color;

import javax.security.auth.Refreshable;
import javax.xml.stream.events.StartDocument;

public abstract class Active_figure extends Figure implements Runnable{
	private Thread myThread=new Thread(this);
	private int working,time;
	public Active_figure(Canvas c, double xx, double yy,int time_,Color cc) {
		super(c, xx, yy,cc);time=time_;myThread.start();
		}
	public abstract void update();
	public void run() {try {
		while(!Thread.interrupted()) {
			synchronized (myThread) {if(working==0)myThread.wait();}
			update();
			canvas.repaint();
			myThread.sleep(time);
		}
	}catch (InterruptedException e) {}
	}
	public void w_start() {working=1;synchronized (myThread) {myThread.notify();}}
	public void w_stop() {working=0;}
	public void w_finish() {myThread.interrupt();}
}
