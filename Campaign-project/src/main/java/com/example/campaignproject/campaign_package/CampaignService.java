package com.example.campaignproject.campaign_package;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campaignproject.campaign_group_package.CampaignGroupModel;
import com.example.campaignproject.campaign_group_package.CampaignGroupRepository;
import com.example.campaignproject.campaign_group_package.CampaignGroupService;

@Service
public class CampaignService implements CrudOperatableInCampaign{

	@Autowired
	private CampaignRepository campaignRepository;
	@Autowired
	private CampaignGroupService campaignGroupService;

	
	@Override
	public List<CampaignModel> findCampaignList() {
		
		return campaignRepository.findAll();
		
	}

	
	@Override
	public List<CampaignGroupModel> getCampaignGroups() {
		
		return campaignGroupService.getAllCampaignGroup();
		
	}

	@Override
	public void saveCampaign(CampaignModel campaignModel) {
		
		campaignRepository.save(campaignModel);

	}

	
	@Override
	public CampaignModel findCampaignById(long id) {

		return campaignRepository.getById(id);

	}

	@Override
	public void updateCampaignGroup(CampaignModel campaignModel) {
		
		campaignRepository.save(campaignModel);
	}

	
	@Override
	public List<CampaignModel> findTop5CampaignList() {
		
		return campaignRepository.findTop5ByOrderByIdDesc();
	}

}
