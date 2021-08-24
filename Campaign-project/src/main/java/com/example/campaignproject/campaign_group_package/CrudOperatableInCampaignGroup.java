package com.example.campaignproject.campaign_group_package;

import java.util.List;

public interface CrudOperatableInCampaignGroup {

	public List<CampaignGroupModel> getTop5CampaignGroup();

	public CampaignGroupModel findCampaignGroupById(long id);

	public void updateCampaignGroup(CampaignGroupModel campaignGroupModel);

	public void saveCampaignGroup(CampaignGroupModel campaignGroupModel);

	public List<CampaignGroupModel> getAllCampaignGroup();

}
