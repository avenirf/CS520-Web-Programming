package cs520_HW1.model;

public class Degree {
	String degree;
	String university;
	int year;
	
	public Degree(String degree, String university, int year){
		this.degree = degree;
		this.university = university;
		this.year = year;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}
