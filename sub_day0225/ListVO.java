package sub_day0225;

public class ListVO {
	String name,num;
	int[] score = new int[3];
	int total,aver;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int[] getScore() {
		return score;
	}
	public void setScore(int[] score) {
		this.score = score;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getAver() {
		return aver;
	}
	public void setAver(int aver) {
		this.aver = aver;
	}
}
