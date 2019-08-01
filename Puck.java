package pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;

public class Puck extends Active_figure {
	private int r;
	private int speedx,speedy;
	private Player i1,i2;
	private int score1;
	private int score2;
	public int getr() {
		return r;
	}
	Label score;
	public Puck(Canvas c,int ii,int ij, int time_,int radius,Player i11,Player i22,Color cc,Label ll) {
		super(c,ii,ij, time_,cc);r=radius;score=ll;
		while(speedx==0)speedx=(int)(Math.random()*3-1);
		while(speedy==0)speedy=(int)(Math.random()*3-1);
		i1=i11;i2=i22;mark='P';
	}
	public int getSpeedx() {
		return speedx;
	}
	public int getSpeedy() {
		return speedy;
	}
	public void reset() {
		score.setText(score1+":"+score2);
		x=canvas.getWidth()/2;y=canvas.getHeight()/2;int l=0;
	speedx=(int)(Math.random()*3-1)==0?-1:1;
	speedy=(int)(Math.random()*3-1)==0?-1:1;
	}
	public void update() {
		if(x-r/2==0) {score2++;reset();}
		else if(x+r/2==canvas.getWidth()-1) {score1++;reset();}
		else if((x-r/2==(i1.getX()+i1.get_Width()) && (y>=i1.getY() && y<=(i1.getY()+i1.get_Height()))) ||
				(x+r/2==(i2.getX()) && (y>=i2.getY() && y<=(i2.getY()+i1.get_Height())))) {speedx=-speedx;x+=speedx;y+=speedy;}
		else if( y==canvas.getHeight()-1) {speedy=-speedy;y--;}
		else if(y==0) {speedy=-speedy;y++;}
		else {x+=speedx;y+=speedy;}
	}
	public void draw() {
		Graphics g=canvas.getGraphics();
		g.setColor(color);
		g.fillOval((int)x,(int) y, r, r);
	}
	
	
}
