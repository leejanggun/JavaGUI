package sub_day0225_11;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
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
import javax.swing.JTextField;

public class CalculatorGUI extends JFrame {

	JFrame jlist;
	JPanel jp,jp1,jp2,jp3,jp4,jp5,jp6;
	JButton enroll,cancel, list, exit;
	JLabel title,uNum,uName,uKor,uEng,uMath;
	JTextField num,name,kor,eng,math;
	TextArea ta_list;
	String sName;
	CalculatorSystem calc = new CalculatorSystem();
	ListVO vo =new ListVO();
	ArrayList<ListVO> voList  = new ArrayList<ListVO>();
	int[] score = new int[3];
	EventObject eo = new EventObject();
	ListGUI listGUI ;
	CalculatorGUI(){
		jp = new JPanel();
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		enroll = new JButton("등록");
		cancel = new JButton("취소");
		list = new JButton("리스트");
		exit = new JButton("종료");
		enroll.addActionListener(eo);
		cancel.addActionListener(eo);
		list.addActionListener(eo);
		title = new JLabel("Score Mgm System");
		uNum = new JLabel("학번 ");
		uName = new JLabel("이름 ");
		uKor = new JLabel("국어 ");
		uEng = new JLabel("영어 ");
		uMath = new JLabel("수학");
		num = new JTextField(10);
		name = new JTextField(10);
		kor = new JTextField(10);
		eng = new JTextField(10);
		math = new JTextField(10);
		jp.setLayout(new BorderLayout(10,10));
		jp.setLayout(new FlowLayout());
		jp.add(title,BorderLayout.NORTH);
		jp1.add(uNum);	jp1.add(num);
		jp2.add(uName);	jp2.add(name);
		jp3.add(uKor);	jp3.add(kor);
		jp4.add(uEng);	jp4.add(eng);
		jp5.add(uMath);	jp5.add(math);
		jp6.add(enroll);	jp6.add(cancel);	jp6.add(list);
		
		setLayout(new GridLayout(7,1));
		add(jp);
		add(jp1);
		add(jp2);
		add(jp3);
		add(jp4);
		add(jp5);
		add(jp6);
		setSize(400,400);
		setVisible(true);
		addWindowListener(eo);
	}
	
	class EventObject extends WindowAdapter implements ActionListener {

		public void windowClosing(WindowEvent e) {
			JOptionPane.showMessageDialog(null, "종료합니다.");
			System.exit(0);
		}
		public void actionPerformed(ActionEvent e) {
			sName = e.getActionCommand();
			if(sName.equals("등록")) {
				if(validationCheck()) {
					
				}else {
					voList.add(input());
				}
				
			}else if(sName.equals("취소")) {
				
			}else if(sName.equals("리스트")) {
				if(voList.size() == 0) {
					JOptionPane.showMessageDialog(null, "데이터가 없습니다");
				}else {
					listShow();
				}
			}else if(sName.equals("종료")) {
				System.out.println("종료");
				System.exit(0);
			}
		}
	}
	public boolean validationCheck() {
		if(num.getText().equals("")||name.getText().equals("")||
				kor.getText().equals("")||eng.getText().equals("")||
				math.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "빈칸이 있습니다");
			return true;
		}else
			return false;
	}
	public ListVO input() {

		ListVO vo = new ListVO();
		vo.setNum(num.getText().trim());
		vo.setName(name.getText().trim());
		vo.setKor(Integer.parseInt(kor.getText().trim()));
		vo.setEng(Integer.parseInt(eng.getText().trim()));
		vo.setMath(Integer.parseInt(math.getText().trim()));
		vo.setTotal(calc.calcTotal(vo.getKor(),vo.getEng(),vo.getMath()));
		vo.setAver(calc.calcAver(vo.getTotal()));
		JOptionPane.showMessageDialog(this, "등록이 성공적으로 완료되었습니다.");
		num.setText("");name.setText("");kor.setText("");eng.setText("");math.setText("");
		return vo;
	}
	public void listShow() {
		jlist =new JFrame();
		ta_list = new TextArea(200,200);
		ta_list.setEditable(false);
		ta_list.append("===============text area 출력===============\n");
		ta_list.append("===========================================\n");
		ta_list.append("===========================================\n");
		ta_list.append("학번\t이름\t국어\t영어\t수학\t총점\t평균\n");
		for(ListVO vo: voList) {
			ta_list.append(vo.getNum()+"\t");
			ta_list.append(vo.getName()+"\t");
			ta_list.append(vo.getKor()+"\t");
			ta_list.append(vo.getEng()+"\t");
			ta_list.append(vo.getMath()+"\t");
			ta_list.append(vo.getTotal()+"\t");
			ta_list.append(vo.getAver()+"\t");
		}
		
		jlist.add(ta_list);
		jlist.setVisible(true);
		jlist.setSize(300,300);
		jlist.setLocation(300,100);
	}
}
