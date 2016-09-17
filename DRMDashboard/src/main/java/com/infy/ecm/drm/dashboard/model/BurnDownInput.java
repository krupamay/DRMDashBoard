package com.infy.ecm.drm.dashboard.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;

@XmlRootElement
public class BurnDownInput {

	private String day;
	private String sprint;
	private String team;
	private Date date;
	private Integer remianing;
	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}
	/**
	 * @return the sprint
	 */
	public String getSprint() {
		return sprint;
	}
	/**
	 * @param sprint the sprint to set
	 */
	public void setSprint(String sprint) {
		this.sprint = sprint;
	}
	/**
	 * @return the team
	 */
	public String getTeam() {
		return team;
	}
	/**
	 * @param team the team to set
	 */
	public void setTeam(String team) {
		this.team = team;
	}
	/**
	 * @return the date
	 */
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="UTC")
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the remianing
	 */
	public Integer getRemianing() {
		return remianing;
	}
	/**
	 * @param remianing the remianing to set
	 */
	public void setRemianing(Integer remianing) {
		this.remianing = remianing;
	}
	
	
}
