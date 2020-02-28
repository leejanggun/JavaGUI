package day0228;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SearchList extends Util {

	//search	
		JPanel jp_search1,jp_search2,jp_search3,jp_stotal;
		JLabel jl_searchName;
		JTextField jt_searchName;
		JTextArea searchTxta;
		JButton searchbtn;
		SignIn main;
		Search search = new Search();
		ArrayList<UserVO> searchVOList;
		EventObject eo = new EventObject();
		
		
		
		SearchList(){
			
		}
		SearchList(SignIn main){
			this.main = main;
			jp_stotal = main.jp_stotal;
		}
		
		void searchList() {
			main.switching("search");
			jp_search1 = new JPanel();
			jp_search2 = new JPanel();
			jp_search3 = new JPanel();
			searchTxta = new JTextArea();
			searchTxta.setSize(10, 30);
			jl_searchName = new JLabel("이름 >>> ");
			jt_searchName = new JTextField(20);
			searchTxta.append("======================목록=======================\n");
			searchTxta.append("이름\t나이\t아이디\t비밀번호\n");
			searchTxta.append("================================================\n");
			searchbtn = new JButton("찾기");
			searchbtn.addActionListener(eo);
			jp_search1.add(jl_searchName);	jp_search1.add(jt_searchName);
			jp_search2.add(searchbtn);
			jp_search3.add(searchTxta);
			jp_stotal.add(jp_search1);
			jp_stotal.add(jp_search2);
			jp_stotal.add(jp_search3);
			main.add(jp_stotal,BorderLayout.CENTER);
			main.setVisible(true);
		}
		
		void searchPrintInfo(ArrayList<UserVO> searchVOList) {
			searchTxta.append("======================목록=======================\n");
			searchTxta.append("이름\t나이\t아이디\t비밀번호\n");
			searchTxta.append("================================================\n");
			for(UserVO vo : searchVOList) {
					searchTxta.append(vo.getUserName()+"\t");
					searchTxta.append(Integer.toString(vo.getUserAge())+"\t");
					searchTxta.append(vo.getUserID()+"\t");
					searchTxta.append(vo.getUserPW()+"\t");
					searchTxta.append("\n");
			}
		}
		class EventObject implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					Object obj = e.getSource();
					if(obj == searchbtn) {
						searchTxta.setText("");
					JOptionPane.showMessageDialog(null, "검색 시작");
					searchPrintInfo(search.searchInfo(jt_searchName.getText(),main.voList));
				}
			}
		}
}
