package day0224;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameObject3  {

	//Field
	Frame f;
	//Constructor
	FrameObject3(){
		f = new Frame("������ �׽�Ʈ");
		f.setVisible(true);
		f.setSize(300,300);
		f.addWindowListener(new FrameObjectEvent());
	}
	//Method
	//�̺�Ʈ ó���� ���� inner class ����
	//inner class �� ȣ������� ���⶧���� ��ü ������ ���ʿ䰡 ����.
	//�̸� delegation ���¶� �ϸ� �������̶��Ѵ�. �ڹٿ����� �̸� ���� ����Ѵ�. 
	class FrameObjectEvent implements WindowListener{

		public void windowOpened(WindowEvent e) {
			
		}

		public void windowClosing(WindowEvent e) {
			System.out.println("�����մϴ�.");
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
