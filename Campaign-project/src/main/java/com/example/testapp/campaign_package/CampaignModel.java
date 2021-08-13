package com.example.testapp.campaign_package;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.testapp.campaign_group_package.CampaignGroupModel;

@Entity(name = "campaign")
public class CampaignModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private String description;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
	private Date startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
	private Date endDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "campaign_group_id", nullable = false)
	private CampaignGroupModel campaignGroupModel;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public CampaignGroupModel getCampaignGroupModel() {
		return campaignGroupModel;
	}

	public void setCampaignGroupModel(CampaignGroupModel campaignGroupModel) {
		this.campaignGroupModel = campaignGroupModel;
	}

	@Override
	public String toString() {
		return "CampaignModel [id=" + id + ", name=" + name + ", description=" + description + ", startDate="
				+ startDate + ", endDate=" + endDate + ", campaignGroupModel=" + campaignGroupModel + "]";
	}

}
