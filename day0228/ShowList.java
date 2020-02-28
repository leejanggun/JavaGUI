package day0228;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ShowList {

	SignIn main;
	JPanel jp_ltotal ;
	JTextArea listTxta;
	ShowList(){
		
	}
	ShowList(SignIn main){
		this.main = main;
		jp_ltotal = main.jp_ltotal;
	}
	
	void showList() {
		main.switching("list");
		listTxta = new JTextArea();
		listTxta.setSize(10, 30);
		listTxta.append("======================목록=======================\n");
		listTxta.append("이름\t나이\t아이디\t비밀번호\n");
		listTxta.append("================================================\n");
		for(UserVO vo: main.voList) {
			listTxta.append(vo.getUserName()+"\t");
			listTxta.append(Integer.toString(vo.getUserAge())+"\t");
			listTxta.append(vo.getUserID()+"\t");
			listTxta.append(vo.getUserPW()+"\t");
			listTxta.append("\n");
		}
		jp_ltotal.add(listTxta);
		main.add(jp_ltotal,BorderLayout.CENTER);
		main.setVisible(true);
	}
}
