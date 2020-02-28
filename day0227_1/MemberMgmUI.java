package day0227_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemberMgmUI extends JFrame{

	//Field
	
	public static final int REGISTER =1;
	public static final int LIST =2;
	public static final int SEARCH =3;
	public static final int UPDATE =4;
	public static final int DELETE =5;
	
	//start
	JPanel mainPane, menuPane;
	JButton btnReg, btnList, btnSearch, btnUpdate, btnDelete, btnExit;
	JLabel jl_title;
	Font font = new Font("맑은 고딕", Font.BOLD, 12);
	
//	//register
//	JPanel regPane, jp_name,jp_addr,jp_label,jp_btn;
//	JLabel jl_name,jl_addr,jl_label;
//	JTextField jt_name,jt_addr;
//	JButton jbtn_en,jbtn_can;
	
	
	JPanel regPane,listPane;
	
	
	
	//search
	JPanel searchPane,jp_search,jp_searchResult;
	JLabel jl_searchName;
	JTextField jt_search;
	JTextArea sta;
	
	//update
	JPanel updatePane, jp_updateName,jp_updateAddr,jp_updateSearch;
	JLabel jl_updateName, jl_updateAddr,jl_updateSearchName;
	JTextField jt_updateName, jt_updateAddr,jt_updateSearch;
	
	//delete
	JPanel deletePane, jp_deleteSearch;
	JLabel jl_deleteSearchName;
	JTextField jt_deleteSearch;
		
	EventObject eo = new EventObject(this);
	ArrayList<ListVO> voList = new ArrayList<ListVO>();
	//Constructor
	public MemberMgmUI() {
		start();
	}
	
	//Method
	public void start() {
		
		regPane = new JPanel();
		listPane = new JPanel();
		searchPane = new JPanel();
		updatePane = new JPanel();
		deletePane = new JPanel();
		mainPane = new JPanel();
		menuPane = new JPanel(new GridLayout(10,1));
		jl_title = new JLabel("\n== 회원등록 시스템에 오신것을 환영합니다 ==");
		
		btnReg = new JButton("회원등록");
		btnList = new JButton("회원리스트");
		btnSearch = new JButton("회원검색");
		btnUpdate = new JButton("회원수정");
		btnDelete = new JButton("회원삭제");
		btnExit = new JButton("종료");
		
		btnReg.addActionListener(eo);
		btnList.addActionListener(eo);
		btnSearch.addActionListener(eo);
		btnUpdate.addActionListener(eo);
		btnDelete.addActionListener(eo);
		btnExit.addActionListener(eo);
		
		jl_title.setFont(new Font("맑은 고딕",Font.BOLD,16));
		btnReg.setFont(font);	btnList.setFont(font);  btnSearch.setFont(font);
		btnUpdate.setFont(font);  btnDelete.setFont(font);  
		btnExit.setFont(font);
		
		mainPane.add(jl_title);			
		menuPane.add(btnReg);
		menuPane.add(btnList);
		menuPane.add(btnSearch);
		menuPane.add(btnUpdate);
		menuPane.add(btnDelete);
		menuPane.add(btnExit);

		add(menuPane, BorderLayout.WEST);
		add(mainPane, BorderLayout.CENTER);
		
		setSize(600,500);
		
		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize(); 
		int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
		int height =(int)(scsize.getHeight()-fsize.getHeight())/2;
		
		addWindowListener(eo);
		
		setLocation(width, height);
		setVisible(true);

	}//start method
	
	

	public void search() {
//		switching("search");
		switching(MemberMgmUI.SEARCH);
		jp_search = new JPanel();
		jp_searchResult = new JPanel();
		jl_searchName = new JLabel("검색명 >>>");
		jt_search = new JTextField(30);
		sta = new JTextArea(20,40);
		sta.setEditable(false);
		jp_search.add(jl_searchName);	jp_search.add(jt_search);
		jp_searchResult.add(sta);
		searchPane.add(jp_search);
		searchPane.add(jp_searchResult);
		
		add(searchPane,BorderLayout.CENTER);
		setVisible(true);
	}
	public void update() {
//		switching("update");
		switching(MemberMgmUI.UPDATE);
		jp_updateSearch = new JPanel();
		jp_updateName = new JPanel();
		jp_updateAddr = new JPanel();
		jl_updateName =new JLabel("이름 >>>");
		jl_updateAddr =new JLabel("주소 >>>");
		jl_updateSearchName =new JLabel("수정 이름 >>>");
		jt_updateName= new JTextField(15);
		jt_updateAddr= new JTextField(15);
		jt_updateSearch= new JTextField(15);

		jp_updateSearch.add(jl_updateSearchName);
		jp_updateSearch.add(jt_updateSearch);
		jp_updateName.add(jl_updateName);
		jp_updateName.add(jt_updateName);
		jp_updateAddr.add(jl_updateAddr);
		jp_updateAddr.add(jt_updateAddr);
		
		updatePane.add(jp_updateSearch);
		updatePane.add(jp_updateName);
		updatePane.add(jp_updateAddr);
		
		add(updatePane,BorderLayout.CENTER);
		setVisible(true);
	}
	public void delete() {
//		switching("delete");
		switching(MemberMgmUI.DELETE);
		jp_deleteSearch = new JPanel();
		jl_deleteSearchName = new JLabel("삭제명 >>>");
		jt_deleteSearch = new JTextField(20);
		
		jp_deleteSearch.add(jl_deleteSearchName);
		jp_deleteSearch.add(jt_deleteSearch);
		deletePane.add(jp_deleteSearch);
		
		add(deletePane,BorderLayout.CENTER);
		setVisible(true);
		
	}
	public void switching(String menu) {
		
		resetPane();
		if(menu.equals("register")) {
			regPane.removeAll();
			regPane.setVisible(true);
		}else if(menu.equals("list")) {
			listPane.removeAll();
			listPane.setVisible(true);
		}else if(menu.equals("search")) {
			searchPane.removeAll();
			searchPane.setVisible(true);
		}else if(menu.equals("update")) {
			updatePane.removeAll();
			updatePane.setVisible(true);
		}else if(menu.equals("delete")) {
			deletePane.setVisible(true);
			deletePane.removeAll();
		}
	}
	public void switching(int menu) {
		
		resetPane();
		switch(menu) {
		case 1:
			regPane.removeAll();
			regPane.setVisible(true);
			break;
		case 2:
			listPane.removeAll();
			listPane.setVisible(true);
			break;
		case 3:
			searchPane.removeAll();
			searchPane.setVisible(true);
			break;
		case 4: 
			updatePane.removeAll();
			updatePane.setVisible(true);
			break;
		case 5: 
			deletePane.setVisible(true);
			deletePane.removeAll();
			break;
		}
		
	}
	void resetPane(){
		regPane.setVisible(false);
		mainPane.setVisible(false);
		listPane.setVisible(false);
		searchPane.setVisible(false);
		updatePane.setVisible(false);
		deletePane.setVisible(false);
	}
	
	//메세지를 입력받아 JLabel 생성하고 폰트를 수정하여 리턴
	public JLabel getMsg(String msg) {
		JLabel message = new JLabel(msg);
		message.setFont(font);
		return message;
		
	}
	class EventObject extends WindowAdapter implements ActionListener{

		JLabel test = new JLabel("프로그램 종료");
		MemberMgmUI main;
		@Override
		public void windowClosing(WindowEvent e) {
			JOptionPane.showMessageDialog(null, "종료");
		}
		EventObject(){
			
		}
		EventObject(MemberMgmUI main){
			this.main = main;
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			Object obj = ae.getSource();
			if(btnReg == obj) {
				JOptionPane.showMessageDialog(null, "등록");
				new MemberRegister(main).register();
			}else if(btnList == obj) {
				new MemberList(main).list();
			}else if(btnSearch == obj) {
				search();
			}else if(btnUpdate == obj) {
				update();
			}else if(btnDelete ==obj) {
				delete();
			}else if (btnExit == obj) {
				if(JOptionPane.showConfirmDialog(null,getMsg("종료하시겠습니까?"))==0) {
					System.exit(0);
				}
			}
		}
		
	}
	
}//class