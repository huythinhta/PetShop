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
	private int idschudle;
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
}
