package day0224;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JFrameObject {

	JFrame jf;
	JFrameObject(){
		
		jf = new JFrame();
		JPanel jp_title = new JPanel();
		JPanel jp_id = new JPanel();
		JPanel jp_pw = new JPanel();
		JPanel jp_btn = new JPanel();
		JLabel title = new JLabel("로그인 폼");
		JLabel id = new JLabel("아이디  ");
		JLabel pw = new JLabel("비밀번호");
		JTextField tid = new JTextField(10);
		JTextField tpw = new JTextField(10);
		JButton login = new JButton("로그인");
		JButton signin = new JButton("회원가입");
		jp_title.add(title);
		jp_id.add(id);	jp_id.add(tid);
		jp_pw.add(pw);	jp_pw.add(tpw);
		jp_btn.add(login);	jp_btn.add(signin);
		jp_btn.setLayout(new FlowLayout());
		jf.setLayout(new GridLayout(4,1));
		jf.add(jp_title);
		jf.add(jp_id);
		jf.add(jp_pw);
		jf.add(jp_btn);
		jf.setSize(300, 300);
		jf.setVisible(true);
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("종료");
				System.exit(0);
			}
		});
	}
	//이벤트 핸들러 메소드 호출(리스너)

	
}
