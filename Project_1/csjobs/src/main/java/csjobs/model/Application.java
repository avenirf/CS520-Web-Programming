package csjobs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "applications",
    uniqueConstraints = @UniqueConstraint(
        columnNames = { "job_id", "applicant_id" }) )
public class Application implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Job job;
	
	@ManyToOne
	private User applicant;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "start_year")
	private Integer start_year;
	
    @ElementCollection
    @CollectionTable(name = "application_degrees",
        joinColumns = @JoinColumn(name = "application_id") )
    @OrderBy("year desc")
	private List<Degree> degrees;
	
	@Column(name = "curriculum_vitae")
	private FileS c_v;
	
	@Column(name = "research_statement")
	private FileS research_s;
	
	@Column(name = "teaching_statement")
	private FileS teaching_s;
	
	@OneToMany(mappedBy = "application",
			cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@OrderColumn(name = "round_index")
	private List<Round> rounds;
	
	public Application()
    {
		degrees = new ArrayList<Degree>();
		rounds = new ArrayList<Round>();
		for( int i = 0; i < 3; ++i ){
			rounds.add( new Round( this ) );
		}
    }
	
    public Application( Job job, User applicant )
    {
        this();
        this.job = job;
        this.applicant = applicant;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getStart_year() {
		return start_year;
	}

	public void setStart_year(Integer start_year) {
		this.start_year = start_year;
	}

	public List<Degree> getDegree() {
		return degrees;
	}

	public void setDegree(List<Degree> degree) {
		this.degrees = degree;
	}

	public User getApplicant() {
		return applicant;
	}

	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}

	public FileS getC_v() {
		return c_v;
	}

	public void setC_v(FileS c_v) {
		this.c_v = c_v;
	}

	public FileS getResearch_s() {
		return research_s;
	}

	public void setResearch_s(FileS research_s) {
		this.research_s = research_s;
	}

	public FileS getTeaching_s() {
		return teaching_s;
	}

	public void setTeaching_s(FileS teaching_s) {
		this.teaching_s = teaching_s;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public List<Round> getRounds() {
		return rounds;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}
	
}
