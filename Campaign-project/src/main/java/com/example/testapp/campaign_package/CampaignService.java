package com.example.testapp.campaign_package;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testapp.campaign_group_package.CampaignGroupModel;
import com.example.testapp.campaign_group_package.CampaignGroupService;

@Service
public class CampaignService {

	@Autowired
	private CampaignRepository campaignRepository;
	@Autowired
	private CampaignGroupService campaignGroupService;
	

	public List<CampaignModel> findCampaignList() {
		
		return campaignRepository.findAll();
		
	}

	public List<CampaignGroupModel> getCampaignGroups() {
		
		return campaignGroupService.getAllCampaignGroup();
	}

	public void saveCampaign(CampaignModel campaignModel) {
		campaignRepository.save(campaignModel);
		
	}

	public CampaignModel findCampaignById(long id) {
		
		return campaignRepository.getById(id);
		
	}

	public void updateCampaignGroup(CampaignModel campaignModel) {
		campaignRepository.save(campaignModel);
		
	}
	
	

}
