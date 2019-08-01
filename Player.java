package pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Player extends Active_figure {
	private int width,height;
	private Puck puck;
	private int pos;
	int speedy=1;
	private double startx,starty;
	public Player(Canvas c, double xx, double yy, int time_,int vis,int sir,int dirr,Color cc) {
		super(c, xx, yy, time_,cc);height=vis;width=sir;pos=dirr;
		mark='I';startx=xx;starty=yy;
		}
	public void reset() {
		x=startx;y=starty;
	}
	public void setpuck(Puck p) {puck=p;}
	public void update() {
		if(puck.getX()-puck.getr()/2==0 || puck.getX()+puck.getr()/2==canvas.getWidth()-1)reset();
		else if((pos==-1 && puck.getSpeedx()==-1) || (pos==1 && puck.getSpeedx()==1) ) {
		if(puck.getSpeedy()==1)speedy=1;
		else speedy=-1;}
		if(y==0 || y==(canvas.getHeight()-1-height)){
			if(y==0) {y++;speedy=-speedy;}
			else if(y==(canvas.getHeight()-1-height)) {y--;speedy=-speedy;}
		}
		else y+=speedy;
		
	}
	public int get_Width() {
		return width;
	}
	public int get_Height() {
		return height;
	}
	public void draw() {
		Graphics g=canvas.getGraphics();
		g.setColor(color);
		g.fillRect((int)x,(int) y, width, height);
	}

}
