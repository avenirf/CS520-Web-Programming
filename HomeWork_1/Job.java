package cs520_HW1.model;

public class Job {
	String job;
	String date;
	
	int index;
	
	public Job (String job, String date_s, int index){
		this.job = job;
		this.index = index;
		this.date = date_s;		
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
}
