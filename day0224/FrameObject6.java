package day0224;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameObject6 extends Frame implements WindowListener{
	
	//Filed
	Frame f ;
	Button b,c,d,e,g;  
	public void windowOpened(WindowEvent e) {
		
	}
	public void windowClosing(WindowEvent e) {
		System.out.println("¡æ∑·");
		System.exit(0);
	}
	public void windowClosed(WindowEvent e) {
		
	}
	public void windowIconified(WindowEvent e) {
		
	}
	public void windowDeiconified(WindowEvent e) {
		
	}
	public void windowActivated(WindowEvent e) {
		
	}
	public void windowDeactivated(WindowEvent e) {
		 
	}
	//Constructor
	FrameObject6(){
//		f= new Frame("æ»≥Á«œººø‰");
		setTitle("æ»≥Á«œººø‰");
		setLayout(new FlowLayout());
		add(b = new Button("∫œ!"));
		add(c = new Button("≥≤!"));
		add(d = new Button("µø!"));
		add(e = new Button("º≠!"));
		add(g = new Button("¡ﬂæ”!"));
		setSize(300, 300);
		setVisible(true);
		addWindowListener(this);
		
	}
	//Method
}
