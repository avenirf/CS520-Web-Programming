package csjobs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "jobs")
public class Job implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;

	private String title;

	private String description;
	 
	@Column(name = "published_on")
	private Date publish_date;
	
	@Column(name = "closed_on")
	private Date close_date;
	
	@Column(nullable = false)
	private boolean closed = false;
	
	@ManyToOne
	@JoinColumn(name = "committee_chair_id")
	private User committeeChair;
	
	@ManyToMany
	@JoinTable(name="job_committee_members",
		joinColumns = @JoinColumn(name = "job_id"),
	    inverseJoinColumns = @JoinColumn(name = "user_id") )
	@OrderBy("lastName asc")
	private List<User> reviewers;
	
    @OneToMany(mappedBy = "job")
    @OrderBy("date asc")
    private List<Application> applications;
	
    @Transient
    private boolean check = false;
    
	public Job()
    {
		reviewers = new ArrayList<User>();
		applications = new ArrayList<Application>();
    }
	
    public boolean isPublished()
    {
        return publish_date != null && publish_date.before( new Date() );
    }

    public boolean isClosed()
    {
        return close_date != null && close_date.before( new Date() );
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public Date getClose_date() {
		return close_date;
	}

	public void setClose_date(Date close_date) {
		this.close_date = close_date;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public List<User> getReviewers() {
		return reviewers;
	}

	public void setReviewers(List<User> reviewers) {
		this.reviewers = reviewers;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public User getCommitteeChair() {
		return committeeChair;
	}

	public void setCommitteeChair(User committeeChair) {
		this.committeeChair = committeeChair;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
	
}
