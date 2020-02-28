package sub_day0225_11;

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
	
	
	JLabel unum,uname,ukor,ueng,umath,utotal,uaver;
	JLabel num,name,kor,eng,math,total,aver;
	JButton back,exit;
	JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8;
	String bname;
	EventObject eo = new EventObject();
	JLabel[] labelList =new JLabel[7];
	
	ArrayList<JLabel[]> arrList = new ArrayList<JLabel[]>();
	ArrayList<JPanel> panList = new ArrayList<JPanel>();
	ListGUI(ArrayList<ListVO> voList){
		panList.add(jp1 = new JPanel());
		panList.add(jp2 = new JPanel());
		panList.add(jp3 = new JPanel());
		panList.add(jp4 = new JPanel());
		panList.add(jp5 = new JPanel());
		panList.add(jp6 = new JPanel());
		panList.add(jp7 = new JPanel());
		panList.add(jp8 = new JPanel());
		unum = new JLabel("�й� > ");
		uname = new JLabel("�̸� > ");
		ukor = new JLabel("���� > ");
		ueng = new JLabel("���� > ");
		umath = new JLabel("���� > ");
		utotal = new JLabel("���� > ");
		uaver = new JLabel("��� > ");
		JLabel[] infoList = {unum,uname,ukor,ueng,umath,utotal,uaver};
		back = new JButton("Ȯ��");
		exit = new JButton("����");
		back.addActionListener(eo);
		exit.addActionListener(eo);
		setLayout(new GridLayout(8,8));
		arrList.add(infoList);
		for(int i=0;i<infoList.length;i++) {
			panList.get(i).add(infoList[i]);
			add(panList.get(i));
		}
		
		for(int i=0;i<voList.size();i++) {
			labelList[0] = new JLabel(voList.get(i).getNum());
			labelList[1] = new JLabel(voList.get(i).getName());
			labelList[2] = new JLabel(Integer.toString(voList.get(i).getKor()));
			labelList[3] = new JLabel(Integer.toString(voList.get(i).getEng()));
			labelList[4] = new JLabel(Integer.toString(voList.get(i).getMath()));
			labelList[5] = new JLabel(Integer.toString(voList.get(i).getTotal()));
			labelList[6] = new JLabel(Integer.toString(voList.get(i).getAver()));
			arrList.add(labelList);
			for(int j=0; j<labelList.length;j++) {
				panList.get(j).add(labelList[j]);
				add(panList.get(j));
			}
		}
		panList.get(7).add(back);
		panList.get(7).add(exit);
		add(panList.get(7));
		setSize(300,300);
		setVisible(true);
	}
	class EventObject extends WindowAdapter implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			bname = e.getActionCommand();
			if(bname.equals("Ȯ��")) {
				setVisible(false);
			}else if(bname.equals("����")) {
				System.out.println("�����մϴ�");
				System.exit(0);
			}
		}
	}
}
