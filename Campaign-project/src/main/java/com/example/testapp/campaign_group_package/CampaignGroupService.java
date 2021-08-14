package com.example.testapp.campaign_group_package;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class CampaignGroupService {
	

	@Autowired
	CampaignGroupRepository campaignGroupRepository;

	public List<CampaignGroupModel> getTop5CampaignGroup() {

		return campaignGroupRepository.findTop5ByOrderByIdDesc();

	}

	
	public CampaignGroupModel findCampaignGroupById(long id) {

		return campaignGroupRepository.findById(id);

	}
	

	public void updateCampaignGroup(CampaignGroupModel campaignGroupModel) {

		try {
			CampaignGroupModel campaignGroup = campaignGroupRepository.findById(campaignGroupModel.getId());
			campaignGroup.setName(campaignGroupModel.getName());
			campaignGroup.setDescription(campaignGroupModel.getDescription());
			campaignGroupRepository.save(campaignGroup);
		} catch (Exception e)  {
			
		}

	}

	public void saveCampaignGroup(CampaignGroupModel campaignGroupModel) {
		campaignGroupRepository.save(campaignGroupModel);

	}


	public List<CampaignGroupModel> getAllCampaignGroup() {
		// TODO Auto-generated method stub
		return campaignGroupRepository.findAll();
	}



}
