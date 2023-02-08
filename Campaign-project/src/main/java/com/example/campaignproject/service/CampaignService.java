package com.example.campaignproject.service;

import com.example.campaignproject.model.Campaign;

import java.util.List;

public interface CampaignService {
	
	public List<Campaign> findCampaigns();
	public void saveCampaign(Campaign campaign);
	public Campaign getCampaign(long id);
	public void deleteCampaign(Campaign campaign);
	public List<Campaign> findTop5CampaignList();


}
