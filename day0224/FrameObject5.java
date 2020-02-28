package day0224;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.BorderLayout;
import java.awt.Button;

public class FrameObject5 extends Frame {

	//Filed
	Frame f;
	Button b,c,d,e,g;  
	//Constructor
	FrameObject5(){
		setTitle("상속받은 프레임 생성");
//		버튼 생성
		add(b = new Button("북!"),BorderLayout.NORTH);
		add(c = new Button("남!"),BorderLayout.SOUTH);
		add(d = new Button("동!"),BorderLayout.EAST);
		add(e = new Button("서!"),BorderLayout.WEST);
		add(g = new Button("중앙!"),BorderLayout.CENTER);
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
