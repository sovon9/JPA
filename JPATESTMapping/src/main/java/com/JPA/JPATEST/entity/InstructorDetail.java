package com.JPA.JPATEST.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_profile")
	private String youtubeProfile;
	
	@Column(name="hobby")
	private String hobby;

	public InstructorDetail() {
		super();
	}

	public InstructorDetail(String youtubeProfile, String hobby) {
		super();
		this.youtubeProfile = youtubeProfile;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeProfile() {
		return youtubeProfile;
	}

	public void setYoutubeProfile(String youtubeProfile) {
		this.youtubeProfile = youtubeProfile;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeProfile=" + youtubeProfile + ", hobby=" + hobby + "]";
	}
	
}
