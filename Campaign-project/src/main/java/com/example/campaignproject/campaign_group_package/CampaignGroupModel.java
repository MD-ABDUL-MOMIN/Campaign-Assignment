package com.example.campaignproject.campaign_group_package;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.campaignproject.campaign_package.CampaignModel;

@Entity(name = "campaigngroup")
public class CampaignGroupModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String description;

	@OneToMany(mappedBy = "campaignGroupModel" ,cascade = CascadeType.ALL)
	List<CampaignModel> campaignList = new ArrayList<CampaignModel>();
	
	
	public List<CampaignModel> getCampaignList() {
		return campaignList;
	}

	public void setCampaignList(List<CampaignModel> campaignList) {
		this.campaignList = campaignList;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
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

	@Override
	public String toString() {
		return "CampaignGroupModel [id=" + id + ", name=" + name + ", description=" + description + ", campaignList="
				+ campaignList + "]";
	}

}
