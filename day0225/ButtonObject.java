package day0225;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonObject extends Frame {

	public ButtonObject() {
		
		ButtonObjectEvent event = new ButtonObjectEvent();
		Panel btnPanel = new Panel();
		Button btn1 = new Button("�α���");
		Button btn2 = new Button("���");
		
		btnPanel.add(btn1); 	btnPanel.add(btn2); 
		btn1.addActionListener(event);
		btn2.addActionListener(event);
		add(btnPanel);
		setSize(300,300);
		setVisible(true);
		addWindowListener(new ButtonObjectEvent());
	}
	
	//�̺�Ʈ ó���� ���� inner class

	class ButtonObjectEvent extends WindowAdapter implements ActionListener{

		
		public void windowClosing(WindowEvent e) {
			System.out.println("����");
			System.exit(0);
		}

		public void actionPerformed(ActionEvent e) {
			String name =e.getActionCommand();
			System.out.println(name+"��ư Ŭ��~~");
			if(name == "�α���") {
				System.out.println("�α��� �õ�");
			}else {
				System.out.println("����");
				System.exit(0);
			}
		}
		
	}
}
