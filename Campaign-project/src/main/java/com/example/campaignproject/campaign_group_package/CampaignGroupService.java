package com.example.campaignproject.campaign_group_package;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class CampaignGroupService implements CrudOperatableInCampaignGroup{

	@Autowired
	private CampaignGroupRepository campaignGroupRepository;
	
	
	@Override
	public List<CampaignGroupModel> getTop5CampaignGroup() {

		return campaignGroupRepository.findTop5ByOrderByIdDesc();

	}

	@Override
	public CampaignGroupModel findCampaignGroupById(long id) {

		return campaignGroupRepository.findById(id);

	}

	@Override
	public void updateCampaignGroup(CampaignGroupModel campaignGroupModel) {

		try {
			CampaignGroupModel campaignGroup = campaignGroupRepository.findById(campaignGroupModel.getId());
			campaignGroup.setName(campaignGroupModel.getName());
			campaignGroup.setDescription(campaignGroupModel.getDescription());
			campaignGroupRepository.save(campaignGroup);
		} catch (Exception e) {
			System.out.println(e);

		}

	}

	@Override
	public void saveCampaignGroup(CampaignGroupModel campaignGroupModel) {
		campaignGroupRepository.save(campaignGroupModel);

	}

	@Override
	public List<CampaignGroupModel> getAllCampaignGroup() {
		// TODO Auto-generated method stub
		return campaignGroupRepository.findAll();
	}

}
