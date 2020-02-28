package sub_day0225;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListGUI extends JFrame {
	
	
	JLabel num,name,kor,eng,math,unum,uname,ukor,ueng,umath;
	JButton back,exit;
	JPanel jp1,jp2,jp3,jp4,jp5;
	String bname;
	String lName,lNum;
	int[] score = new int[3];
	int total,aver;
	ListGUI(ListVO vo){
		
		lNum =vo.getNum();
		lName =vo.getName();
		score =vo.getScore();
		total =vo.getTotal();
		aver = vo.getAver();
		jp1= new JPanel();
		jp2= new JPanel();
		jp3= new JPanel();
		jp4= new JPanel();
		jp5= new JPanel();
		unum = new JLabel("학번 : ");
		uname = new JLabel("이름 : ");
		ukor = new JLabel("국어 : ");
		ueng = new JLabel("영어 : ");
		umath = new JLabel("수학 : ");
		num = new JLabel(lNum);
		name = new JLabel(lName);
		kor = new JLabel(Integer.toString(score[0]));
		eng = new JLabel(Integer.toString(score[1]));
		math = new JLabel(Integer.toString(score[2]));
		jp1.add(unum);	jp1.add(num);
		jp2.add(uname);	jp2.add(name);
		jp3.add(ukor);	jp3.add(kor);
		jp4.add(ueng);	jp4.add(eng);
		jp5.add(umath);	jp5.add(math);
		setLayout(new GridLayout(5,1));
		add(jp1);
		add(jp2);
		add(jp3);
		add(jp4);
		add(jp5);
		setSize(300,300);
		setVisible(true);
	}
	class EventObject extends WindowAdapter implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
}
