package day0227;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SelectUpdate extends Util {
	
	SignIn main;
	JPanel jp_stotal;
	JTextField jt_updateNum;
	JLabel jl_updateNum;
	JButton selectbtn;
	int num ;
	
	ArrayList<Integer> numList ;
	EventObject eo = new EventObject();
	
	SelectUpdate(){
	}
	SelectUpdate(SignIn main,ArrayList<Integer> numList){
		this.main = main;
		this.numList = numList;
	}
	void selectList() {
		jp_stotal =new JPanel();
		jl_updateNum = new JLabel("업데이트할 번호 >>>");
		jt_updateNum = new JTextField(10);
		selectbtn = new JButton("확인");
		selectbtn.addActionListener(eo);
		jp_stotal.add(jl_updateNum);
		jp_stotal.add(jt_updateNum);
		jp_stotal.add(selectbtn);
		add(jp_stotal);
		setSize(200,200);
		setVisible(true);
	}
	class EventObject implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			if(obj == selectbtn) {
				num = Integer.parseInt(jt_updateNum.getText());
				JOptionPane.showMessageDialog(null, "확인");
				setVisible(false);
				if(numList.size() >=num) {
					if(JOptionPane.showConfirmDialog(null, "정말 변경하시겠습니까?")==0)
						new UpdateList().start(main.voList,numList.get(num-1)-1);
				}else{
					JOptionPane.showMessageDialog(null, "번호를 제대로 입력해주세요");
				}
				num=0;
			}
		}
	}
}
