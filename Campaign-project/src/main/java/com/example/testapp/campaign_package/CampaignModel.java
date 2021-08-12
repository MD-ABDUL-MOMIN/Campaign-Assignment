package com.example.testapp.campaign_package;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.example.testapp.campaign_group_package.CampaignGroupModel;

@Entity
public class CampaignModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	
	@OneToMany
	List<CampaignGroupModel> campaignGroup;

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

	public List<CampaignGroupModel> getCampaignGroup() {
		return campaignGroup;
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

	public void setCampaignGroup(List<CampaignGroupModel> campaignGroup) {
		this.campaignGroup = campaignGroup;
	}
	
	
	
	

}
