package day0228;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends Util{

	SignIn main;
	EventObject eo = new EventObject();
	JButton login;
	Login(){
		
	}
	Login(SignIn main){
		this.main = main;
		JPanel jp_title = new JPanel();
		JPanel jp_id = new JPanel();
		JPanel jp_pw = new JPanel();
		JPanel jp_btn = new JPanel();
		JLabel title = new JLabel("�α��� ��");
		JLabel id = new JLabel("���̵�  ");
		JLabel pw = new JLabel("��й�ȣ");
		JTextField tid = new JTextField(10);
		JTextField tpw = new JTextField(10);
		login = new JButton("�α���");
		login.addActionListener(eo);
		jp_title.add(title);
		jp_id.add(id);	jp_id.add(tid);
		jp_pw.add(pw);	jp_pw.add(tpw);
		jp_btn.add(login);
		jp_btn.setLayout(new FlowLayout());
		setLayout(new GridLayout(4,1));
		add(jp_title);
		add(jp_id);
		add(jp_pw);
		add(jp_btn);
		setSize(300, 300);
		setVisible(true);
		
	}
	class EventObject implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			if(obj == login) {
				JOptionPane.showMessageDialog(null, "����");
				setVisible(false);
				main.start();
			}
		}
		
	}
	//�̺�Ʈ �ڵ鷯 �޼ҵ� ȣ��(������)

	
}
