package kr.co.job.jdbc;

public class Dto {
	// DTO -> db랑 똑같은 필드명, 생성자, 게터세터를 가지는 클래스 (test01 테이블이지만 편의상 클래스 이름 info로 지정)
	private int tno;
	private String pname;
	private int age;
	private String etc;
	
	public Dto() {}
	
	public Dto(int tno, String pname, int age, String etc) {
		super();
		this.tno = tno;
		this.pname = pname;
		this.age = age;
		this.etc = etc;
	}
	
	public int getTno() {
		return this.tno;
	}
	
	public void setTno(int tno) {
		this.tno = tno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	@Override
	public String toString() {
		return "tno : " + tno + ", pname : " + pname + ", age : " + age + ", etc : " + etc;
	}

}
