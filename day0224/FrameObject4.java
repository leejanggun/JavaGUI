package day0224;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameObject4 extends Frame {

	//Filed
	Frame f;
	//Constructor
	FrameObject4(){
		setTitle("��ӹ��� ������ ����");
		setVisible(true);
		setSize(300, 300);
		//Anoymous inner class�� �����Ͽ� �̺�Ʈ ó��
//		ȣ��Ǵ� ��ġ�� ����
//		addWindowListener(�̺�Ʈ ó���� ��ü)
		addWindowListener(new WindowListener() {

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
			
		});
	}
	//Method
	
}
