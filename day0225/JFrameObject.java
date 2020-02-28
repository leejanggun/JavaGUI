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
		
		Font font = new Font("맑은 고딕",Font.BOLD,12);
		jf = new JFrame();
		EventObjectTest eot =new EventObjectTest();
		JPanel jp_title = new JPanel();
		JPanel jp_id = new JPanel();
		JPanel jp_pw = new JPanel();
		JPanel jp_btn = new JPanel();
		JLabel title = new JLabel("로그인 폼");
		title.setFont(font);
		JLabel id = new JLabel("아이디  ");
		JLabel pw = new JLabel("비밀번호");
		id.setFont(font);
		pw.setFont(font);
		tid = new JTextField(10);
		tpw = new JPasswordField(10);
		tid.setFont(font);
		tpw.setFont(font);
		
		JButton login = new JButton("로그인");
		JButton signin = new JButton("회원가입");
		JButton exit = new JButton("종료");
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
	//이벤트 핸들러 메소드 호출(리스너)

	class EventObjectTest extends WindowAdapter implements ActionListener{
		public void windowClosing(WindowEvent e) {
			System.out.println("종료합니다");
			System.exit(0);
		}
		public void actionPerformed(ActionEvent e) {
			name = e.getActionCommand();
			if(name.equals("로그인")||tpw ==e.getSource()) {
				if(validationCheck()) {
					
				}
				else {
					loginCheck();
				}
			}else if(name.equals("회원가입")) {
				System.out.println("회원가입");
				ButtonObject bo = new ButtonObject();
			}else if(name.equals("종료")) {
				System.out.println("종료합니다.");
				System.exit(0);
			}
		}
		
	}
	//데이터 유효성 체크
	public boolean validationCheck() {
		if(tid.getText().equals("")||tpw.getText().equals("")) {
			JOptionPane.showMessageDialog(jf, "빈칸이 존재합니다.");
			if(tid.getText().equals(""))
				tid.requestFocus();
			else
				tpw.requestFocus();
			return true;
		}else
			return false;
	}
	public void loginCheck() {
		if(name.equals("로그인")) {
			System.out.println("로그인");
			String did = "test";
			String dpw = "1234";
			String uid = tid.getText().trim();
			String upw = tpw.getText().trim();
			System.out.println("ID : "+uid+" upw : " +upw);
			if(uid.equals(did)) {
				if(dpw.equals(upw)) {
					System.out.println("로그인 성공");
					JOptionPane.showMessageDialog(jf, "로그인 성공");
				}else {
					System.out.println("비밀번호가 틀렸습니다.");
					JOptionPane.showMessageDialog(jf, "비밀번호가 잘못됬습니다." );
				}
			}else {
				System.out.println("아이디가 잘못됬습니다.");
				JOptionPane.showMessageDialog(jf, "아이디가 잘못됬습니다.");
			}
			tid.setText("");
			tpw.setText("");
		}

	}
	
}
