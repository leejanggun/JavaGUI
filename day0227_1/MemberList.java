package day0227_1;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import day0227.UserVO;

public class MemberList {

	//list
		JPanel listPane;
		JTextArea ta;
		
		MemberMgmUI main;
		MemberList(){
			
		}
		MemberList(MemberMgmUI main){
			this.main=main;
			listPane = main.listPane;
		}

	public void list() {
//		switching("list");
		main.switching(MemberMgmUI.LIST);
		
		ta = new JTextArea(10,20);
		ta.append("리스트입니다.\n");
		ta.append("======================목록=======================\n");
		ta.append("이름\t나이");
		ta.append("================================================\n");
		for(ListVO vo: main.voList) {
			ta.append(vo.getName()+"\t");
			ta.append(vo.getAddr()+"\t");
			ta.append("\n");
		}
		listPane.add(ta);
		main.add(listPane,BorderLayout.CENTER);
		main.setVisible(true);
	}
}
