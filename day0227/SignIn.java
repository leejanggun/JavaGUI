package day0227;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SignIn extends JFrame {
	

	JPanel jp_starttotal = new JPanel();
	JPanel jp_etotal = new JPanel();
	JPanel jp_ltotal = new JPanel();
	JPanel jp_stotal = new JPanel();
	JPanel jp_utotal = new JPanel();
	JPanel jp_dtotal = new JPanel();
	
//start	
	JPanel jp_start1;
	JLabel jl_welcome,jl_img;
	JButton enroll,list,search,update,delete,exit;

//list

	ArrayList<UserVO> voList = new ArrayList<UserVO>();
	ArrayList<UserVO> searchVOList;
	ArrayList<Integer> numList = new ArrayList<Integer>();
	UserVO vo;
	EventObject eo = new EventObject(this);
	SignIn(){
		start();
	}
	
	class EventObject extends WindowAdapter implements ActionListener{

		SignIn main;
		EventObject(){
			
		}
		EventObject(SignIn main){
			this.main = main;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj==enroll) {
				JOptionPane.showMessageDialog(null, "회원 등록");
				new Enroll(main).enrollment();
			}else if(obj==list){
				if(voList.size()<=0) {
					JOptionPane.showMessageDialog(null, "회원 등록부터 해주세요");
				}else {
					JOptionPane.showMessageDialog(null, "목록");
					new ShowList(main).showList();
				}
			}else if(obj == search) {
				if(voList.size()<=0) {
					JOptionPane.showMessageDialog(null, "회원 등록부터 해주세요");
				}else {
					JOptionPane.showMessageDialog(null, "검색");
					new SearchList(main).searchList();
				}
			}else if(obj == update) {
				if(voList.size()<=0) {
					JOptionPane.showMessageDialog(null, "회원 등록부터 해주세요");
				}else {
					JOptionPane.showMessageDialog(null, "수정");
					new Update(main).update();
				}
			}else if(obj == delete) {
				if(voList.size()<=0) {
					JOptionPane.showMessageDialog(null, "회원 등록부터 해주세요");
				}else {
					JOptionPane.showMessageDialog(null, "삭제");
					new Delete(main).delete();
				}
			}else if( obj == exit) {
				if(JOptionPane.showConfirmDialog(null, "종료하시겠습니까?")==0) {
					System.exit(0);
				}
			}
		}
	}
	void removePane() {
		jp_starttotal.setVisible(false);
		jp_etotal.setVisible(false);
		jp_ltotal.setVisible(false);
		jp_stotal.setVisible(false);
		jp_utotal.setVisible(false);
		jp_dtotal.setVisible(false);
	}
	void switching(String name) {
		removePane();
		if(name.equals("enroll")) {
			jp_etotal.removeAll();
			jp_etotal.setVisible(true);
		}else if(name.equals("list")) {
			jp_ltotal.removeAll();
			jp_ltotal.setVisible(true);
		}else if(name.equals("search")) {
			jp_stotal.removeAll();
			jp_stotal.setVisible(true);
		}else if(name.equals("update")) {
			jp_utotal.removeAll();
			jp_utotal.setVisible(true);
		}else if(name.equals("delete")) {
			jp_dtotal.removeAll();
			jp_dtotal.setVisible(true);
		}
		
	}
	void start() {
		
		jp_etotal = new JPanel();
		jp_ltotal = new JPanel();
		jp_stotal = new JPanel();
		jp_utotal = new JPanel();
		jp_start1 = new JPanel();
		jp_starttotal = new JPanel();
		enroll =new JButton("회원 등록");
		list =new JButton("회원 리스트");
		search =new JButton("회원 검색");
		update =new JButton("회원 수정");
		delete =new JButton("회원 삭제");
		exit = new JButton("종료");
		enroll.addActionListener(eo);
		list.addActionListener(eo);
		search.addActionListener(eo);
		update.addActionListener(eo);
		delete.addActionListener(eo);
		exit.addActionListener(eo);
		jl_img = new JLabel(new ImageIcon("src/day0226/main.png"));
		jl_welcome = new JLabel("======= 어서오세요 =======");
		jp_start1.setLayout(new GridLayout(6,1));
		jp_start1.add(enroll);
		jp_start1.add(list);
		jp_start1.add(search);
		jp_start1.add(update);
		jp_start1.add(delete);
		jp_start1.add(exit);
		jp_starttotal.add(jl_img);
		jp_starttotal.add(jl_welcome);
		add(jp_start1,BorderLayout.WEST);
		add(jp_starttotal);
		setSize(600	,500);
		setVisible(true);
	}
	
}
