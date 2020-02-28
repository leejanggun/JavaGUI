package day0225;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JFrameObject {

	JFrame jf;
	JTextField tid;
	JPasswordField tpw;
	String name;
	JFrameObject(){
		
		Font font = new Font("���� ���",Font.BOLD,12);
		jf = new JFrame();
		EventObjectTest eot =new EventObjectTest();
		JPanel jp_title = new JPanel();
		JPanel jp_id = new JPanel();
		JPanel jp_pw = new JPanel();
		JPanel jp_btn = new JPanel();
		JLabel title = new JLabel("�α��� ��");
		title.setFont(font);
		JLabel id = new JLabel("���̵�  ");
		JLabel pw = new JLabel("��й�ȣ");
		id.setFont(font);
		pw.setFont(font);
		tid = new JTextField(10);
		tpw = new JPasswordField(10);
		tid.setFont(font);
		tpw.setFont(font);
		
		JButton login = new JButton("�α���");
		JButton signin = new JButton("ȸ������");
		JButton exit = new JButton("����");
		login.setFont(font);
		signin.setFont(font);
		exit.setFont(font);
		
		login.addActionListener(eot);
		signin.addActionListener(eot);
		exit.addActionListener(eot);
		tpw.addActionListener(eot);
		jp_title.add(title);
		jp_id.add(id);	jp_id.add(tid);
		jp_pw.add(pw);	jp_pw.add(tpw);
		jp_btn.add(login);	jp_btn.add(signin);	jp_btn.add(exit);
		jp_btn.setLayout(new FlowLayout());
	
		jf.setLayout(new GridLayout(4,1));
		jf.add(jp_title);
		jf.add(jp_id);
		jf.add(jp_pw);
		jf.add(jp_btn);
		
		Dimension scsize =Toolkit.getDefaultToolkit().getScreenSize();
		jf.setSize(300, 300);
		Dimension fsize = jf.getSize();
		System.out.println("width = " + fsize.width);
		System.out.println("height = " + fsize.height);
		int height = (int)(scsize.height-fsize.getHeight())/2;
		int width = (int)(scsize.width-fsize.getWidth())/2;
		jf.setLocation(width, height);
		jf.setVisible(true);
		jf.addWindowListener(eot);
	}
	//�̺�Ʈ �ڵ鷯 �޼ҵ� ȣ��(������)

	class EventObjectTest extends WindowAdapter implements ActionListener{
		public void windowClosing(WindowEvent e) {
			System.out.println("�����մϴ�");
			System.exit(0);
		}
		public void actionPerformed(ActionEvent e) {
			name = e.getActionCommand();
			if(name.equals("�α���")||tpw ==e.getSource()) {
				if(validationCheck()) {
					
				}
				else {
					loginCheck();
				}
			}else if(name.equals("ȸ������")) {
				System.out.println("ȸ������");
				ButtonObject bo = new ButtonObject();
			}else if(name.equals("����")) {
				System.out.println("�����մϴ�.");
				System.exit(0);
			}
		}
		
	}
	//������ ��ȿ�� üũ
	public boolean validationCheck() {
		if(tid.getText().equals("")||tpw.getText().equals("")) {
			JOptionPane.showMessageDialog(jf, "��ĭ�� �����մϴ�.");
			if(tid.getText().equals(""))
				tid.requestFocus();
			else
				tpw.requestFocus();
			return true;
		}else
			return false;
	}
	public void loginCheck() {
		if(name.equals("�α���")) {
			System.out.println("�α���");
			String did = "test";
			String dpw = "1234";
			String uid = tid.getText().trim();
			String upw = tpw.getText().trim();
			System.out.println("ID : "+uid+" upw : " +upw);
			if(uid.equals(did)) {
				if(dpw.equals(upw)) {
					System.out.println("�α��� ����");
					JOptionPane.showMessageDialog(jf, "�α��� ����");
				}else {
					System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
					JOptionPane.showMessageDialog(jf, "��й�ȣ�� �߸�����ϴ�." );
				}
			}else {
				System.out.println("���̵� �߸�����ϴ�.");
				JOptionPane.showMessageDialog(jf, "���̵� �߸�����ϴ�.");
			}
			tid.setText("");
			tpw.setText("");
		}

	}
	
}
