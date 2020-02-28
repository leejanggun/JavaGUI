package day0227;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateList extends JFrame {
	JPanel jp_uName,jp_uAge,jp_uID,jp_uPW;
	JLabel uName,uAge,uID,uPW;
	JTextField name,age,id,pw;
	JButton updatebtn;
	ArrayList<UserVO> voList;
	EventObject eo = new EventObject();
	int number;
	
	void start(ArrayList<UserVO> voList,int number){
		this.voList = voList;
		this.number = number;
		setLayout(new GridLayout(5,1));
		jp_uName = new JPanel();
		jp_uAge = new JPanel();
		jp_uID = new JPanel();
		jp_uPW = new JPanel();
		uName = new JLabel("이름");
		uAge = new JLabel("나이");
		uID = new JLabel("아이디");
		uPW = new JLabel("비밀번호");
		name = new JTextField(20);
		age = new JTextField(20);
		id = new JTextField(20);
		pw = new JTextField(20);
		updatebtn = new JButton("변경");
		updatebtn.addActionListener(eo);
		
		jp_uName.add(uName);	jp_uName.add(name);
		jp_uAge.add(uAge);	jp_uAge.add(age);
		jp_uID.add(uID);	jp_uID.add(id);
		jp_uPW.add(uPW);	jp_uPW.add(pw);
		add(jp_uName);
		add(jp_uAge);
		add(jp_uID);
		add(jp_uPW);
		add(updatebtn);
		setSize(300,300);
		setVisible(true);
	}
	public boolean enrollCheck() {
		boolean flag =false;
		if(name.getText().equals("")||age.getText().equals("")||
				id.getText().equals("")||pw.getText().equals("")) {
			if(name.getText().equals("")) {
				name.requestFocus();
				JOptionPane.showMessageDialog(null, "이름이 비었습니다");
			}else if(age.getText().equals("")) {
				age.requestFocus();
				JOptionPane.showMessageDialog(null, "나이가 비었습니다");
			}else if(id.getText().equals("")) {
				id.requestFocus();
				JOptionPane.showMessageDialog(null, "아이디가 비었습니다");
			}else if(pw.getText().equals("")){
				pw.requestFocus();
				JOptionPane.showMessageDialog(null, "비밀번호가 비었습니다");
			}
		}else
			flag =true;
		
		return flag;
	}
	
	class EventObject implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj == updatebtn) {
				if(enrollCheck()==true) {
					voList.get(number).setUserName(name.getText());
					voList.get(number).setUserAge(Integer.parseInt(age.getText()));
					voList.get(number).setUserID(id.getText());
					voList.get(number).setUserPW(pw.getText());
					JOptionPane.showMessageDialog(null, "업데이트 완료");
					setVisible(false);
				}
			}
		}
	}
}
