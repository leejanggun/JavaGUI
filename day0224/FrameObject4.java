package day0224;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameObject4 extends Frame {

	//Filed
	Frame f;
	//Constructor
	FrameObject4(){
		setTitle("상속받은 프레임 생성");
		setVisible(true);
		setSize(300, 300);
		//Anoymous inner class를 생성하여 이벤트 처리
//		호출되는 위치에 생성
//		addWindowListener(이벤트 처리할 객체)
		addWindowListener(new WindowListener() {

			public void windowOpened(WindowEvent e) {
			}
			public void windowClosing(WindowEvent e) {
				System.out.println("종료합니다.");
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
			
		});
	}
	//Method
	
}
