package pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure {
	public Figure(Canvas c,double xx,double yy,Color cc) {color=cc;x=xx;y=yy;canvas=c;}
	protected Canvas canvas;
	protected double x;
	protected double y;
	protected Color color;
	protected char mark;
	public abstract void draw();
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public char getMark() {
		return mark;
	}
	
}
