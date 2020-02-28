package day0226;

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

public class SignIn {
	JFrame jf = new JFrame();

//start	
	JPanel jp_start1,jp_start2;
	JLabel jl_welcome;
	JButton enroll,list,search,correct,delete;

//enroll	
	JPanel jp_enroll1,jp_enroll2,jp_etotal,jp2_1,jp2_2,jp2_3,jp2_4;
	JLabel iName,iAge,iID,iPW,jl_img;
	JTextField name,age,id,pw,lName,lAge,lID,lPW;
	JButton enbtn;

//list
	JPanel jp_ltotal;
	JTextArea listTxta;

//search	
	JPanel jp_search1,jp_search2,jp_search3,jp_stotal;
	JLabel jl_searchName;
	JTextField jt_searchName;
	JTextArea searchTxta;
	JButton searchbtn;
	
//update	
	JPanel jp_update1,jp_update2,jp_utotal;
	JTextField jt_updateName;
	JLabel jl_updateName;
	JButton updatebtn;
	JTextArea updateTxta;

	Object obj;
	String mname;
	ArrayList<UserVO> voList = new ArrayList<UserVO>();
	ArrayList<UserVO> searchVOList;
	ArrayList<Integer> numList = new ArrayList<Integer>();
	UserVO vo;
	EventObject eo = new EventObject();
	SignIn(){
		start();
	}
	
	class EventObject extends WindowAdapter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj==enroll) {
				JOptionPane.showMessageDialog(null, "회원 등록");
				enrollment();
			}else if(obj==list){
				JOptionPane.showMessageDialog(null, "목록");
				showList();
			}else if(obj == search) {
				searchList();
			}else if(obj == correct) {
				updateList();
			}else if(obj == delete) {
				deleteList();
			}else if(obj == enbtn) {
				voList.add(input());
				JOptionPane.showMessageDialog(null, "등록완료");
			}else if(obj == searchbtn) {
				JOptionPane.showMessageDialog(null, "검색 시작");
				searchPrintInfo(searchInfo(jt_searchName.getText()));
			}else if(obj ==updatebtn) {
				JOptionPane.showMessageDialog(null, "업데이트 완료");
				updateInfo(searchInfo(jt_updateName.getText()));
			}
		}
	}
	void switching(String name) {
		jp_start2.setVisible(false);
		jp_etotal.setVisible(false);
		jp_ltotal.setVisible(false);
		jp_stotal.setVisible(false);
		jp_utotal.setVisible(false);
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
		}
		
	}
	void start() {
		
		jp_etotal = new JPanel();
		jp_ltotal = new JPanel();
		jp_stotal = new JPanel();
		jp_utotal = new JPanel();
		jp_start1 = new JPanel();
		jp_start2 = new JPanel();
		enroll =new JButton("회원 등록");
		list =new JButton("회원 리스트");
		search =new JButton("회원 검색");
		correct =new JButton("회원 수정");
		delete =new JButton("회원 삭제");
		enroll.addActionListener(eo);
		list.addActionListener(eo);
		search.addActionListener(eo);
		correct.addActionListener(eo);
		delete.addActionListener(eo);
		jl_img = new JLabel(new ImageIcon("src/day0226/main.png"));
		jl_welcome = new JLabel("======= 어서오세요 =======");
		jp_start1.setLayout(new GridLayout(5,1));
		jp_start1.setSize(100, 400);
		jp_start1.add(enroll);
		jp_start1.add(list);
		jp_start1.add(search);
		jp_start1.add(correct);
		jp_start1.add(delete);
		jp_start2.add(jl_img);
		jp_start2.add(jl_welcome);
		jf.add(jp_start1,BorderLayout.WEST);
		jf.add(jp_start2);
		jf.setSize(500,500);
		jf.setVisible(true);
	}
	void enrollment() {
		switching("enroll");
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
		jp_enroll1.setLayout(new GridLayout(4,1));
		jp2_1.add(iName);	jp2_1.add(name);
		jp2_2.add(iAge);	jp2_2.add(age);
		jp2_3.add(iID);		jp2_3.add(id);
		jp2_4.add(iPW);		jp2_4.add(pw);
		jp_enroll1.add(jp2_1);
		jp_enroll1.add(jp2_2);
		jp_enroll1.add(jp2_3);
		jp_enroll1.add(jp2_4);
		jp_enroll2.add(enbtn);
		jp_etotal.add(jp_enroll1);
		jp_etotal.add(jp_enroll2);
		jf.add(jp_etotal,BorderLayout.CENTER);
		jf.setSize(400,400);
		jf.setVisible(true);
	}
	UserVO input() {
		vo =new UserVO();
		vo.setUserName(name.getText());
		vo.setUserAge(Integer.parseInt(age.getText().trim()));
		vo.setUserID(id.getText());
		vo.setUserPW(pw.getText());
		return vo;
	}
	void showList() {
		switching("list");
		listTxta = new JTextArea();
		listTxta.setSize(10, 30);
		listTxta.append("======================목록=======================\n");
		listTxta.append("이름\t나이\t아이디\t비밀번호\n");
		listTxta.append("================================================\n");
		for(UserVO vo: voList) {
			listTxta.append(vo.getUserName()+"\t");
			listTxta.append(Integer.toString(vo.getUserAge())+"\t");
			listTxta.append(vo.getUserID()+"\t");
			listTxta.append(vo.getUserPW()+"\t");
			listTxta.append("\n");
		}
		jp_ltotal.add(listTxta);
		jf.add(jp_ltotal,BorderLayout.CENTER);
		jf.setVisible(true);
	}
	void searchList() {
		switching("search");
		jp_search1 = new JPanel();
		jp_search2 = new JPanel();
		jp_search3 = new JPanel();
		searchTxta = new JTextArea();
		searchTxta.setSize(10, 30);
		jl_searchName = new JLabel("이름 >>> ");
		jt_searchName = new JTextField(20);
		searchTxta.append("======================목록=======================\n");
		searchTxta.append("이름\t나이\t아이디\t비밀번호\n");
		searchTxta.append("================================================\n");
		searchbtn = new JButton("찾기");
		searchbtn.addActionListener(eo);
		jp_search1.add(jl_searchName);	jp_search1.add(jt_searchName);
		jp_search2.add(searchbtn);
		jp_search3.add(searchTxta);
		jp_stotal.add(jp_search1);
		jp_stotal.add(jp_search2);
		jp_stotal.add(jp_search3);
		jf.add(jp_stotal,BorderLayout.CENTER);
		jf.setVisible(true);
	}
	ArrayList searchInfo(String str) {
		searchVOList = new ArrayList<UserVO>();
		int cnt=0;
		for(UserVO vo : voList) {
			if(vo.getUserName().equals(str)) {
				searchVOList.add(vo);
			}else
				JOptionPane.showMessageDialog(null, "찾는 정보가 없습니다.");
		}
		return searchVOList;
	}
	void searchPrintInfo(ArrayList<UserVO> searchVOList) {
		for(UserVO vo : searchVOList) {
				searchTxta.append(vo.getUserName()+"\t");
				searchTxta.append(Integer.toString(vo.getUserAge())+"\t");
				searchTxta.append(vo.getUserID()+"\t");
				searchTxta.append(vo.getUserPW()+"\t");
				searchTxta.append("\n");
		}
	}
	void updateList() {
		switching("update");
		jp_update1 =new JPanel();
		jp_update2 =new JPanel();
		jl_updateName = new JLabel("업데이트할 이름 >>>");
		jt_updateName = new JTextField(20);
		updatebtn = new JButton("업데이트");
		updatebtn.addActionListener(eo);
	}
	
	void updateInfo(ArrayList<UserVO> searchInfo) {
	}
	void deleteList() {
		switching("delete");
		
	}
	
}
