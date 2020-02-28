package day0227_1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberRegister {
	//register
		JPanel regPane, jp_name,jp_addr,jp_label,jp_btn;
		JLabel jl_name,jl_addr,jl_label;
		JTextField jt_name,jt_addr;
		JButton jbtn_en,jbtn_can;
		MemberMgmUI main;
		EventObject eo = new EventObject();
		ListVO vo;
		MemberRegister(){
			
		}
		MemberRegister(MemberMgmUI main){
			this.main = main;
			regPane= main.regPane;
		}
		public void register() {
			
//			switching("register");
			main.switching(MemberMgmUI.REGISTER);
			jp_label = new JPanel();
			jp_name = new JPanel();
			jp_addr = new JPanel();
			jp_btn = new JPanel();
			jl_label = new JLabel("==========회원 등록==========");
			jl_name = new JLabel("나이 > ");
			jl_addr = new JLabel("주소 > ");
			jt_name = new JTextField(30);
			jt_addr = new JTextField(30);
			jbtn_en = new JButton("등록");
			jbtn_can = new JButton("다시쓰기");
			jbtn_en.addActionListener(eo);
			jbtn_can.addActionListener(eo);
			
			jp_label.add(jl_label);
			jp_name.add(jl_name);		jp_name.add(jt_name);
			jp_addr.add(jl_addr);		jp_addr.add(jt_addr);
			jp_btn.add(jbtn_en);		jp_btn.add(jbtn_can);
			
			regPane.add(jp_label);
			regPane.add(jp_name);
			regPane.add(jp_addr);
			regPane.add(jp_btn);
			
			main.add(regPane,BorderLayout.CENTER);
			main.setVisible(true);
			
		}
		boolean registerCheck() {
			boolean flag =false;
			if(jt_name.getText().equals("")||jt_addr.getText().equals("")) {
				if(jt_name.getText().equals("")) {
					jt_name.requestFocus();
					JOptionPane.showMessageDialog(null,main.getMsg( "이름이 비었습니다"));
				}else if(jt_addr.getText().equals("")) {
					jt_addr.requestFocus();
					JOptionPane.showMessageDialog(null, main.getMsg( "나이가 비었습니다"));
				}
				
			}else
				flag =true;
			
			return flag;
		}
		ListVO registerProc(){
			vo = new ListVO();
			vo.setName(jt_name.getText());
			vo.setAddr(jt_addr.getText());
			return vo;
		}
		class EventObject implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object obj = e.getSource();
				if(jbtn_en==obj) {
					System.out.println("00");
					if(registerCheck()==true) {
						main.voList.add(registerProc());
						JOptionPane.showMessageDialog(null, "등록");
						jt_name.setText(null);
						jt_addr.setText(null);
					}
//					if(regFormCheck()) registerProc()
				}else if(jbtn_can == obj) {
					jt_name.setText(null);
					jt_addr.setText(null);
				}
			}
			
		}
		
}
