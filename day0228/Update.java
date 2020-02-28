package day0228;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Update extends Util {
	//update	
	
		int cnt;
		SignIn main;
		JPanel jp_update1,jp_update2,jp_utotal;
		JTextField jt_updateName;
		JLabel jl_updateName;
		JButton searchbtn,updatebtn;
		JTextArea updateTxta;
		SelectUpdate selectupdate;
		Search search = new Search();
		EventObject eo = new EventObject();
		ArrayList<Integer> numList = new ArrayList<Integer>();
		Update(){
			
		}
		Update(SignIn main){
			this.main = main;
			jp_utotal = main.jp_utotal;
		}
		
		void update() {
		main.switching("update");
		jl_updateName = new JLabel("������Ʈ�� �̸� >>>");
		jt_updateName = new JTextField(20);
		updateTxta = new JTextArea();
		updateTxta.setEditable(false);
		updateTxta.setSize(10,20);
		
		updateTxta.append("===========================���==========================\n");
		updateTxta.append("��ȣ\t�̸�\t����\t���̵�\t��й�ȣ\n");
		updateTxta.append("========================================================\n");
		searchbtn = new JButton("ã��");
		updatebtn = new JButton("����");
		updatebtn.setEnabled(false);
		searchbtn.addActionListener(eo);
		updatebtn.addActionListener(eo);
		jp_utotal.add(jl_updateName);
		jp_utotal.add(jt_updateName);
		jp_utotal.add(searchbtn);
		jp_utotal.add(updateTxta);
		jp_utotal.add(updatebtn);
		main.add(jp_utotal);
		}
		void searchPrintInfo(ArrayList<UserVO> searchVOList) {
			int cnum=1;
			updateTxta.append("===========================���==========================\n");
			updateTxta.append("��ȣ\t�̸�\t����\t���̵�\t��й�ȣ\n");
			updateTxta.append("========================================================\n");
			for(UserVO vo : searchVOList) {
				updateTxta.append(String.valueOf(cnum++)+"\t");
				updateTxta.append(vo.getUserName()+"\t");
				updateTxta.append(Integer.toString(vo.getUserAge())+"\t");
				updateTxta.append(vo.getUserID()+"\t");
				updateTxta.append(vo.getUserPW()+"\t");
				updateTxta.append("\n");
			}
		}
		
		class EventObject implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object obj = e.getSource();
				if(obj == searchbtn) {
					updateTxta.setText("");
					searchPrintInfo(search.searchInfo(jt_updateName.getText(),main.voList));
					JOptionPane.showMessageDialog(null, "�˻� �Ϸ�");
					cnt =search.getCount();
					numList=search.numList;
					if(search.getCount() >0) {
						updatebtn.setEnabled(true);
						search.setCount(0);
						search.setNumber(0);
					}else
						updatebtn.setEnabled(false);
				}else if(obj == updatebtn) {
					if(cnt==1) {
						if(JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?")==0)
							new UpdateList().start(main.voList,numList.get(0)-1);
						
					}else {
						selectupdate =new SelectUpdate(main,numList);
						selectupdate.selectList();
						
					}
					
				}
			}
			
		}
}
