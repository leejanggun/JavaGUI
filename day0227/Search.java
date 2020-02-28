package day0227;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Search {

	int cnt ;
	int number;
	ArrayList<Integer> numList;
	ArrayList<UserVO> searchVOList; 
	ArrayList<UserVO> searchInfo(String str,ArrayList<UserVO> voList) {
		searchVOList = new ArrayList<UserVO>();
		numList = new ArrayList<Integer>();
		for(UserVO vo : voList) {
			number++;
			if(vo.getUserName().equals(str)) {
				searchVOList.add(vo);
				cnt++;
				numList.add(number);
			}
		}
		if(cnt ==0)
			JOptionPane.showMessageDialog(null, "찾는 정보가 없습니다.");
		return searchVOList;
	}
	int getCount() {
		return cnt;
	}
	void setCount(int cnt) {
		this.cnt = cnt;
	}
	int getNumber() {
		return number;
	}
	void setNumber(int number) {
		this.number =number; 
	}
	
}
