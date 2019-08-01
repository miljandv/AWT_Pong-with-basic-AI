package pong;

import java.awt.*;
import java.util.LinkedList;;

public class Scene extends Canvas {
	private LinkedList<Figure> list=new LinkedList<>();
	public Figure getFigureByIndex(int i) {return list.get(i);}
	public void add(Figure f) {list.add(f);}
	public void paint(Graphics arg0) {
		for (int i = 0; i <list.size(); i++) {
			list.get(i).draw();
		}
	}
	public void w_start() {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) instanceof Active_figure) {
			((Active_figure)list.get(i)).w_start();
			}
		}
	}
	public void w_finish() {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) instanceof Active_figure) {
			((Active_figure)list.get(i)).w_finish();
			}
		}
	}
	public void w_stop() {
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) instanceof Active_figure) {
			((Active_figure)list.get(i)).w_stop();
			}
		}
	}
}
