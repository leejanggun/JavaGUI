package sub_day0225_02;

public class CalculatorSystem {

	String num, name;
	int total,aver;

	int calcTotal(int kor,int eng, int math){
		total = kor + eng + math;
		return total;
	}
	int calcAver(int total) {
		return total/3;
	}
	
}
