package com.spe.ClassroomManagementSystem.Models;

import java.io.File;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Internship implements Serializable {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "internship_id")
	    private Long internshipId;
	 
	 
	 
	    private String internname;
	 
	 
	    private String collegename;
	 
	  @Column
	    private long duration;
	  
	 
	  
	 
	 
	 
	 private File noc;
	 
	 
	 private File resume;
	 
	 
	 public Internship( String internname,  String collegename, long duration,  File noc,
			 File resume, long mob,  String professorEmail) {
		
		this.internname = internname;
		this.collegename = collegename;
		this.duration = duration;
		this.noc = noc;
		this.resume = resume;
		this.mob = mob;
		this.professorEmail = professorEmail;
	}

	public long getMob() {
		return mob;
	}

	public void setMob(long mob) {
		this.mob = mob;
	}

	public String getProfessorEmail() {
		return professorEmail;
	}

	public void setProfessorEmail(String professorEmail) {
		this.professorEmail = professorEmail;
	}

	@Column
	    private long mob;
	 
	 
	 @Column(unique = true)
	    @NotNull
	    private String professorEmail;
	 
	 
	 

	public Long getInternshipId() {
		return internshipId;
	}

	public void setInternshipId(Long internshipId) {
		this.internshipId = internshipId;
	}

	public String getInternname() {
		return internname;
	}

	public void setInternname(String internname) {
		this.internname = internname;
	}

	public String getCollegename() {
		return collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public File getNoc() {
		return noc;
	}

	public void setNoc(File noc) {
		this.noc = noc;
	}

	public File getResume() {
		return resume;
	}

	public void setResume(File resume) {
		this.resume = resume;
	}

//	public Internship(String internname, String collegename, long duration,
//			File noc, File resume) {
//	
//		this.internname = internname;
//		this.collegename = collegename;
//		this.duration = duration;
//		this.noc = noc;
//		this.resume = resume;
//	}

	public Internship() {
	}

	

}
