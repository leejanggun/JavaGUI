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
		Button btn1 = new Button("로그인");
		Button btn2 = new Button("취소");
		
		btnPanel.add(btn1); 	btnPanel.add(btn2); 
		btn1.addActionListener(event);
		btn2.addActionListener(event);
		add(btnPanel);
		setSize(300,300);
		setVisible(true);
		addWindowListener(new ButtonObjectEvent());
	}
	
	//이벤트 처리를 위한 inner class

	class ButtonObjectEvent extends WindowAdapter implements ActionListener{

		
		public void windowClosing(WindowEvent e) {
			System.out.println("종료");
			System.exit(0);
		}

		public void actionPerformed(ActionEvent e) {
			String name =e.getActionCommand();
			System.out.println(name+"버튼 클릭~~");
			if(name == "로그인") {
				System.out.println("로그인 시도");
			}else {
				System.out.println("종료");
				System.exit(0);
			}
		}
		
	}
}
