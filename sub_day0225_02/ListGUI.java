package sub_day0225_02;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListGUI extends JFrame {
	
	
	JLabel num,name,kor,eng,math,total,aver,unum,uname,ukor,ueng,umath,utotal,uaver;
	JButton back,exit;
	JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8;
	String bname;
	EventObject eo = new EventObject();
	JLabel[] labelList =new JLabel[7];
	ArrayList<JLabel[]> arrList = new ArrayList<JLabel[]>();
	ListGUI(ArrayList<ListVO> voList){
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		jp7 = new JPanel();
		jp8 = new JPanel();
		unum = new JLabel("�й� > ");
		uname = new JLabel("�̸� > ");
		ukor = new JLabel("���� > ");
		ueng = new JLabel("���� > ");
		umath = new JLabel("���� > ");
		utotal = new JLabel("���� > ");
		uaver = new JLabel("��� > ");
		back = new JButton("Ȯ��");
		exit = new JButton("����");
		back.addActionListener(eo);
		exit.addActionListener(eo);
	
		num = new JLabel(voList.get(0).getNum());
		name = new JLabel(voList.get(0).getName());
		kor = new JLabel(Integer.toString(voList.get(0).getKor()));
		eng = new JLabel(Integer.toString(voList.get(0).getEng()));
		math = new JLabel(Integer.toString(voList.get(0).getMath()));
		total = new JLabel(Integer.toString(voList.get(0).getTotal()));
		aver = new JLabel(Integer.toString(voList.get(0).getAver()));
		jp1.add(unum);	jp1.add(num);
		jp2.add(uname);	jp2.add(name);
		jp3.add(ukor);	jp3.add(kor);
		jp4.add(ueng);	jp4.add(eng);
		jp5.add(umath);	jp5.add(math);
		jp6.add(utotal);jp6.add(total);
		jp7.add(uaver);	jp7.add(aver);
		jp8.add(back);	jp8.add(exit);
		setLayout(new GridLayout(8,8));
		add(jp1);
		add(jp2);
		add(jp3);
		add(jp4);
		add(jp5);
		add(jp6);
		add(jp7);
		add(jp8);
		setSize(300,300);
		setVisible(true);
	}
	class EventObject extends WindowAdapter implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			bname = e.getActionCommand();
			if(bname.equals("Ȯ��")) {
				
				
			}else if(bname.equals("����")) {
				System.out.println("�����մϴ�");
				System.exit(0);
			}
		}
		
	}
}
