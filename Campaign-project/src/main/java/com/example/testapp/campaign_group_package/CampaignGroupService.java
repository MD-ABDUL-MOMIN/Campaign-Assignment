package com.example.testapp.campaign_group_package;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignGroupService {
	
	@Autowired
	CampaignGroupRepository campaignGroupRepository;

	public List<CampaignGroupModel> getAllCampaignGroup() {
		
		 return campaignGroupRepository.findAll();
		
	}

	public CampaignGroupModel findCampaignGroupById(long id) {
		
		return campaignGroupRepository.findById(id);
		
	}

	public void saveOrUpdateCampaignGroup(CampaignGroupModel campaignGroupModel) {
			boolean added =true;
			if(!campaignGroupModel.equals(null)) {
		CampaignGroupModel campaignGroup = campaignGroupRepository.findById(campaignGroupModel.getId());
			added = false;
			campaignGroupRepository.save(campaignGroupModel);
		}
		
		if(added) {
		   CampaignGroupModel campaignGroup = findCampaignGroupById(campaignGroupModel.getId());
		
			campaignGroup.setName(campaignGroupModel.getName());
			campaignGroup.setDescription(campaignGroupModel.getDescription());
			campaignGroupRepository.save(campaignGroup);
			}
			
		
		
				
	}
		
	}
	

