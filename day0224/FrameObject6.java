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
		System.out.println("����");
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
//		f= new Frame("�ȳ��ϼ���");
		setTitle("�ȳ��ϼ���");
		setLayout(new FlowLayout());
		add(b = new Button("��!"));
		add(c = new Button("��!"));
		add(d = new Button("��!"));
		add(e = new Button("��!"));
		add(g = new Button("�߾�!"));
		setSize(300, 300);
		setVisible(true);
		addWindowListener(this);
		
	}
	//Method
}
