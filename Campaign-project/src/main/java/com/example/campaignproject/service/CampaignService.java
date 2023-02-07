package com.example.campaignproject.service;

import java.util.List;

import com.example.campaignproject.model.CampaignGroup;
import com.example.campaignproject.model.Campaign;

public interface CampaignService {
	
	public List<Campaign> findCampaigns();
	public void saveCampaign(Campaign campaign);
	public Campaign findCampaignById(long id);
	public void deleteCampaign(Campaign campaign);
	public List<Campaign> findTop5CampaignList();


}
