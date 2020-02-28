package sub_day0225;

public class CalculatorSystem {

	String num, name;
	int total,aver;
	int[] score = new int[3];

	int calcTotal(int[] score){
		for(int i=0; i<score.length;i++)
			total+=score[i];
		return total;
	}
	int calcAver(int total) {
		return total/3;
	}
	void printInfo(String num,String name,int[] score){
		this.num = num;
		this.name = name;
		this.score = score;
		total = calcTotal(score);
		aver = calcAver(total);
		System.out.println("ÇÐ¹ø : " +num);
		System.out.println("ÀÌ¸§ : " +name);
		for(int i : score) {
			System.out.println(i);
		}
		System.out.println("ÃÑÁ¡ : " + total);
		System.out.println("Æò±Õ : " + aver);

	}
}
