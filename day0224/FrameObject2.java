package day0224;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameObject2 extends Frame implements WindowListener{
	
	//Filed
	Frame f ;
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
	FrameObject2(){
//		f= new Frame("�ȳ��ϼ���");
		setTitle("�ȳ��ϼ���");
		setVisible(true);
		setSize(300, 300);
		addWindowListener(this);
		
	}
	//Method
}
