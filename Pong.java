package pong;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.lang.model.element.Element;;

public class Pong extends Frame implements ActionListener {
	class we extends WindowAdapter{
		public void windowClosing(WindowEvent arg0) {dispose();}
	}
	Panel hd=new Panel();
	Label score=new Label("0:0");
	Player[] Player=new Player[2];	
	Puck p;
	Button[] buttons=new Button[3];
	private Scene gameScene;
	public Pong() {
		super("Pong");setBounds(500,100,516,370);gameScene =new Scene();
		score.setFont(new Font("Arial",Font.BOLD,20));gameScene.setSize(500,250);
		hd.setBackground(Color.LIGHT_GRAY);
		Player[0]=new Player(gameScene, 15., (gameScene.getHeight()/2-20)*1., 20, 40, 7, -1,Color.blue);
		Player[1]=new Player(gameScene, gameScene.getWidth()-15.-7-1, (gameScene.getHeight()/2-20)*1., 10, 40, 7, 1,Color.red);
		p=new Puck(gameScene,200,125, 10, 10, Player[0], Player[1],Color.green,score);
		Player[0].setpuck(p);
		Player[1].setpuck(p);
		gameScene.add(Player[0]);
		gameScene.add(Player[1]);
		gameScene.add(p);addWindowListener(new we());
		buttons[0]=new Button("Start");
		buttons[1]=new Button("Stop");
		buttons[2]=new Button("Reset");
		Panel ft=new Panel();hd.add(score);score.setAlignment(Label.CENTER);
		ft.add(buttons[0]);buttons[0].addActionListener(this);
		ft.add(buttons[1]);buttons[1].addActionListener(this);
		ft.add(buttons[2]);buttons[2].addActionListener(this);
		add(hd,BorderLayout.NORTH);ft.setBackground(Color.gray);
		add(ft,BorderLayout.SOUTH);
		Panel panel=new Panel();
		panel.add(gameScene);
		add(panel,BorderLayout.CENTER);
		setVisible(true);
	}
	public static void main(String[] args) {
		Pong hokej=new Pong();
	}
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Start")) {gameScene.w_start();}
		else if(arg0.getActionCommand().equals("Stop")) {gameScene.w_stop();}
		else if(arg0.getActionCommand().equals("Reset")) {score.setText("0:0");}
	}

}
