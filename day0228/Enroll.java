package day0228;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class Enroll extends Util {

		ArrayList<UserVO> voList = new ArrayList<UserVO>();
		EventObject eo = new EventObject();
	//enroll	
		SignIn main;
		JPanel jp_enroll1,jp_enroll2,jp_etotal,jp2_1,jp2_2,jp2_3,jp2_4;
		JLabel iName,iAge,iID,iPW;
		JTextField name,age,id,pw,lName,lAge,lID,lPW;
		JButton enbtn;
		UserVO vo ;
		
		
		Enroll(){
			
		}
		Enroll(SignIn main){
			this.main =main;
			jp_etotal =main.jp_etotal;
		}
		void enrollment() {
			main.switching("enroll");
			jp_enroll1 = new JPanel();
			jp_enroll2 =new JPanel();
			jp2_1 = new JPanel();
			jp2_2 = new JPanel();
			jp2_3 = new JPanel();
			jp2_4 = new JPanel();
			iName = new JLabel("이름");
			iAge = new JLabel("나이");
			iID = new JLabel("아이디");
			iPW = new JLabel("비밀번호");
			name = new JTextField(20);
			age = new JTextField(20);
			id = new JTextField(20);
			pw = new JTextField(20);
			enbtn = new JButton("등록");
			enbtn.addActionListener(eo);
			jp_etotal.setLayout(new GridLayout(5,1));
			jp2_1.add(iName);	jp2_1.add(name);
			jp2_2.add(iAge);	jp2_2.add(age);
			jp2_3.add(iID);		jp2_3.add(id);
			jp2_4.add(iPW);		jp2_4.add(pw);
			jp_etotal.add(jp2_1);
			jp_etotal.add(jp2_2);
			jp_etotal.add(jp2_3);
			jp_etotal.add(jp2_4);
			jp_etotal.add(enbtn);
			main.add(jp_etotal,BorderLayout.CENTER);
			main.setSize(500,500);
			main.setVisible(true);
			name.requestFocus();
		}
		UserVO input() {
			vo =new UserVO();
			vo.setUserName(name.getText());
			vo.setUserAge(Integer.parseInt(age.getText().trim()));
			vo.setUserID(id.getText());
			vo.setUserPW(pw.getText());
			return vo;
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
				if(obj == enbtn) {
					if(enrollCheck()==true) {
						main.voList.add(input());
						JOptionPane.showMessageDialog(null, "등록완료");
						name.setText(null);
						age.setText(null);
						id.setText(null);
						pw.setText(null);
					}
				}
			}
		}
		
}
