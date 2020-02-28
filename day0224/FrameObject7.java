package day0224;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.BorderLayout;
import java.awt.Button;

public class FrameObject7 extends Frame {

	//Filed
	Frame f;
	Button b,c,d,e,g;  
	//Constructor
	FrameObject7(){
		setTitle("상속받은 프레임 생성");
//		버튼 생성
		setLayout(new GridLayout(3,2));
		add(b = new Button("1!"));
		add(c = new Button("2!"));
		add(d = new Button("3!"));
		add(e = new Button("4!"));
		add(g = new Button("5!"));
		add(g = new Button("6!"));
		setSize(300, 300);
		setVisible(true);
		
//		addWindowListener(이벤트 처리할 객체)
		addWindowListener(new FrameObject4Event());
	}
	//FrameObject3Event inner class 생성 - 단, 어댑터 클래스를 사용하여 생성
	class FrameObject4Event extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			System.out.println("종료합니다.");
			System.exit(0);
		}
	}
	//Method
}
