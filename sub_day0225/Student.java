package sub_day0225;

import java.util.Scanner;

public class Student {
	
	Scanner sc =new Scanner(System.in);
	String num = "1111", name = "lee";
	int[] score = {100,98,99};
	int[] arr = new int[3];
	String[] str = {"국어", "영어","수학"};
	public void setInfo() {
		System.out.print("번호 >");
		setNum(sc.next());
		System.out.print("이름 >");
		setName(sc.next());
		for(int i=0 ;i<score.length;i++) {
			System.out.print(str[i]+ " > ");
			arr[i] =sc.nextInt();
		}
		setScore(arr);
		
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getScore() {
		return score;
	}
	public void setScore(int[] score) {
		this.score = score;
	}
	
	
	
}
