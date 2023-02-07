package com.example.campaignproject.service.impl;

import java.util.List;

import com.example.campaignproject.service.CampaignGroupService;
import com.example.campaignproject.model.CampaignGroup;
import com.example.campaignproject.repository.CampaignGroupRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CampaignGroupServiceImpl implements CampaignGroupService {


	@NonNull private final CampaignGroupRepository campaignGroupRepository;
	
	
	@Override
	public List<CampaignGroup> getTop5CampaignGroup() {

		return campaignGroupRepository.findTop5ByOrderByIdDesc();

	}

	@Override
	public CampaignGroup findCampaignGroupById(long id) {

		return campaignGroupRepository.findById(id);

	}

	@Override
	public void updateCampaignGroup(CampaignGroup campaignGroupModel) {

		try {
			CampaignGroup campaignGroup = campaignGroupRepository.findById(campaignGroupModel.getId());
			campaignGroup.setName(campaignGroupModel.getName());
			campaignGroup.setDescription(campaignGroupModel.getDescription());
			campaignGroupRepository.save(campaignGroup);
		} catch (Exception e) {
			System.out.println(e);

		}

	}

	@Override
	public void saveCampaignGroup(CampaignGroup campaignGroup) {
		campaignGroupRepository.save(campaignGroup);

	}

	@Override
	public List<CampaignGroup> getAllCampaignGroup() {
		// TODO Auto-generated method stub
		return campaignGroupRepository.findAll();
	}

}
