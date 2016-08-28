package com.infy.ecm.drm.dashboard.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.marklogic.client.pojo.annotation.Id;

@XmlRootElement
public class BurnDownInput {

	@Id
	private Integer id;
	private Integer day;
	private Integer sprint;
	private String team;
	private Date date;
	private Integer remianing;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the day
	 */
	public Integer getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(Integer day) {
		this.day = day;
	}
	/**
	 * @return the sprInteger
	 */
	public Integer getSprInteger() {
		return sprint;
	}
	/**
	 * @param sprInteger the sprInteger to set
	 */
	public void setSprInteger(Integer sprint) {
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
