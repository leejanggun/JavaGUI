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
		setTitle("��ӹ��� ������ ����");
//		��ư ����
		add(b = new Button("��!"),BorderLayout.NORTH);
		add(c = new Button("��!"),BorderLayout.SOUTH);
		add(d = new Button("��!"),BorderLayout.EAST);
		add(e = new Button("��!"),BorderLayout.WEST);
		add(g = new Button("�߾�!"),BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);
		
//		addWindowListener(�̺�Ʈ ó���� ��ü)
		addWindowListener(new FrameObject4Event());
	}
	//FrameObject3Event inner class ���� - ��, ����� Ŭ������ ����Ͽ� ����
	class FrameObject4Event extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			System.out.println("�����մϴ�.");
			System.exit(0);
		}
	}
	//Method
}
