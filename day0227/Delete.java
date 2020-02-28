package day0227;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Delete {
	
	int cnt;
	SignIn main;
	JPanel jp_dtotal;
	JLabel jl_deleteName;
	JTextField jt_deleteName;
	JTextArea deleteTxta;
	JButton searchbtn,deletebtn;
	EventObject eo = new EventObject();
	Search search = new Search();
	ArrayList<Integer> numList = new ArrayList<Integer>();
	SelectDelete selectdelete;
	Delete(){
		
	}
	Delete(SignIn main){
		this.main = main;
		jp_dtotal = main.jp_dtotal;
	}
	void delete() {
		
		main.switching("delete");
		jl_deleteName = new JLabel("������ �̸� >>>");
		jt_deleteName = new JTextField(20);
		deleteTxta = new JTextArea();
		deleteTxta.append("===========================���==========================\n");
		deleteTxta.append("��ȣ\t�̸�\t����\t���̵�\t��й�ȣ\n");
		deleteTxta.append("========================================================\n");
		searchbtn = new JButton("ã��");
		deletebtn = new JButton("����");
		searchbtn.addActionListener(eo);
		deletebtn.addActionListener(eo);
		jp_dtotal.add(jl_deleteName);
		jp_dtotal.add(jt_deleteName);
		jp_dtotal.add(searchbtn);
		jp_dtotal.add(deleteTxta);
		jp_dtotal.add(deletebtn);
		main.add(jp_dtotal);
	}
	void searchPrintInfo(ArrayList<UserVO> searchVOList) {
		int cnum=1;
		deleteTxta.append("===========================���==========================\n");
		deleteTxta.append("��ȣ\t�̸�\t����\t���̵�\t��й�ȣ\n");
		deleteTxta.append("========================================================\n");
		for(UserVO vo : searchVOList) {
			deleteTxta.append(String.valueOf(cnum++)+"\t");
			deleteTxta.append(vo.getUserName()+"\t");
			deleteTxta.append(Integer.toString(vo.getUserAge())+"\t");
			deleteTxta.append(vo.getUserID()+"\t");
			deleteTxta.append(vo.getUserPW()+"\t");
			deleteTxta.append("\n");
		}
	}
	class EventObject implements ActionListener{

		//ArrayList���ÿ��� Iterator ���
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			if(obj ==searchbtn) {
				deleteTxta.setText("");
				searchPrintInfo(search.searchInfo(jt_deleteName.getText(),main.voList));
				JOptionPane.showMessageDialog(null, "�˻� �Ϸ�");
				cnt =search.getCount();
				numList=search.numList;
				if(search.getCount() >0) {
					deletebtn.setEnabled(true);
					search.setCount(0);
					search.setNumber(0);
				}else
					deletebtn.setEnabled(false);
			}else if(obj == deletebtn) {
				if(cnt==1) {
					if(JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?")==0) {
						main.voList.remove(numList.get(0)-1);
						JOptionPane.showMessageDialog(null, "�Ϸ�");
					}
				}else {
					selectdelete =new SelectDelete(main,numList);
					selectdelete.selectList();
				}
			}
		}
		
	}
}
