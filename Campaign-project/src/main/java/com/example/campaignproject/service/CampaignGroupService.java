package com.example.campaignproject.service;

import com.example.campaignproject.model.CampaignGroup;

import java.util.List;

public interface CampaignGroupService {

	public List<CampaignGroup> getTop5CampaignGroup();

	public CampaignGroup getCampaignGroup(long id);

	public void updateCampaignGroup(CampaignGroup campaignGroup);

	public CampaignGroup saveCampaignGroup(CampaignGroup campaignGroup);

	public List<CampaignGroup> getAllCampaignGroup();

    void removeGroup(Long groupId);
}
