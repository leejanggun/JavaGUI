package day0224;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameObject3  {

	//Field
	Frame f;
	//Constructor
	FrameObject3(){
		f = new Frame("프레임 테스트");
		f.setVisible(true);
		f.setSize(300,300);
		f.addWindowListener(new FrameObjectEvent());
	}
	//Method
	//이벤트 처리를 위한 inner class 정리
	//inner class 는 호출될일이 없기때문에 객체 생성을 할필요가 없다.
	//이를 delegation 형태라 하며 위임형이라한다. 자바에서는 이를 자주 사용한다. 
	class FrameObjectEvent implements WindowListener{

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
		
	}
}
