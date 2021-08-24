package com.example.campaignproject.campaign_package;

import java.util.List;

import com.example.campaignproject.campaign_group_package.CampaignGroupModel;

public interface CrudOperatableInCampaign {
	
	public List<CampaignModel> findCampaignList();
	public List<CampaignGroupModel> getCampaignGroups();
	public void saveCampaign(CampaignModel campaignModel);
	public CampaignModel findCampaignById(long id);
	public void updateCampaignGroup(CampaignModel campaignModel);
	public List<CampaignModel> findTop5CampaignList();


}
