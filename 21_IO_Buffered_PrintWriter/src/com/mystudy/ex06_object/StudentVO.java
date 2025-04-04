package com.mystudy.ex06_object;

import java.io.Serializable;

/* 직렬화(Serialization) / 역직렬화(Deserialization)
  - 직렬화(Serialization) : JVM 메모리에 있는 객체를 바이트 스트림으로 변환하는 작업
  - 역직렬화(Deserialization) : 바이트 스트림 데이터를 자바 객체로 변환하는 작업
---------
데이터 전송을 위해서는 직렬화 처리가 가능해야함
직렬화 방법 : Serializable 인터페이스 구현
*/
public class StudentVO implements Serializable {
	//private static final long serialVersionUID = 1L;
	private static final long serialVersionUID = 4496970537538406221L;
	
	private String id; //학생 고유 번호
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	public StudentVO(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public StudentVO(String id, String name, int kor, int eng, int math) {
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		computeTotAvg();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	//총점, 평균 계산처리 메소드 
	public void computeTotAvg() {
		tot = kor + eng + math;
		avg = tot * 100 / 3 / 100.0;
	}

	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", tot="
				+ tot + ", avg=" + avg + "]";
	}	
	
	@Override
	protected StudentVO clone() {
		return new StudentVO(id, name, kor, eng, math);
	}

}
 














