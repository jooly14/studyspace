package spring.aop.entity;

import org.springframework.stereotype.Component;


public class NewLecExam implements Exam {

	private int kor;
	private int eng;
	private int math;
	private int com;
	public NewLecExam() {
		// TODO Auto-generated constructor stub
	}
	public NewLecExam(int kor, int eng, int math, int com) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.com = com;
	}
	
	@Override
	public String toString() {
		return "NewLecExam [kor=" + kor + ", eng=" + eng + ", math=" + math + ", com=" + com + "]";
	}
	@Override
	public int total() {
		int result = kor+eng+math+com;
		if(kor>100) {
			throw new IllegalArgumentException("유효하지 않은 국어점수");
		}
		return result;
	}

	@Override
	public float avg() {
		float result = total() / 4.0f;
		return result;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}
	
}
