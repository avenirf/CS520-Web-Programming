package cs520_HW1.model;

import java.util.ArrayList;

public class Applicant {
	int index; 
	String name;
	ArrayList<Job> job;
	String applied;
	
	ArrayList<Degree> degree;
	
	public Applicant(String name, String applied, int index){
		this.name = name;
		this.job = new ArrayList<Job>();
		this.index = index;		
		this.applied = applied;		
		this.degree = new ArrayList<Degree>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApplied() {
		return applied;
	}

	public void setApplied(String applied) {
		this.applied = applied;
	}

	public ArrayList<Degree> getDegree() {
		return degree;
	}

	public void setDegree(ArrayList<Degree> degree) {
		this.degree = degree;
	}
	
	public void addDegree (Degree degree){
		this.degree.add(degree);
	}
	
	public void deleteDegree (Degree degree){
		this.degree.remove(degree);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ArrayList<Job> getJob() {
		return job;
	}

	public void setJob(ArrayList<Job> job) {
		this.job = job;
	}
	
	public void addJob (Job job){
		this.job.add(job);
	}
	
	public void deleteJob (Job job){
		this.job.remove(job);
	}
}
