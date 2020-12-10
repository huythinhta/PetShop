package pet.petshop.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idschedule;
	private int idservice;
	private int iduser;
	private Date dateorder;
	private Date datacheckin;
	private String note;
	@ManyToOne
	@JoinColumn(name = "iduser",insertable=false, updatable=false )
	private User user;
	@ManyToOne
	@JoinColumn(name = "idservice",insertable=false, updatable=false )
	private Services service;
	
	
	public Schedule() {
		super();
	}
	public Schedule(int idservice, int iduser, Date dateorder, Date datacheckin, String note) {
		super();
		this.idservice = idservice;
		this.iduser = iduser;
		this.dateorder = dateorder;
		this.datacheckin = datacheckin;
		this.note = note;
	}
	public int getIdschedule() {
		return idschedule;
	}
	public void setIdschedule(int idschedule) {
		this.idschedule = idschedule;
	}
	public int getIdservice() {
		return idservice;
	}
	public void setIdservice(int idservice) {
		this.idservice = idservice;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public Date getDateorder() {
		return dateorder;
	}
	public void setDateorder(Date dateorder) {
		this.dateorder = dateorder;
	}
	public Date getDatacheckin() {
		return datacheckin;
	}
	public void setDatacheckin(Date datacheckin) {
		this.datacheckin = datacheckin;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Services getService() {
		return service;
	}
	public void setService(Services service) {
		this.service = service;
	}
	
	
}
