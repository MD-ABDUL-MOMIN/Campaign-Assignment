package com.example.campaignproject.service.impl;

import java.util.List;

import com.example.campaignproject.exception.NotFoundException;
import com.example.campaignproject.model.Campaign;
import com.example.campaignproject.repository.CampaignRepository;
import com.example.campaignproject.service.CampaignService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.campaignproject.model.CampaignGroup;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Service
public class CampaignServiceImpl implements CampaignService {

	@NonNull private final 	CampaignRepository campaignRepository;


	@Override
	public List<Campaign> findCampaigns() {
		
		return campaignRepository.findAll();
		
	}

	@Override
	public void saveCampaign(Campaign campaign) {
		
		campaignRepository.save(campaign);

	}

	
	@Override
	public Campaign getCampaign(long id) {

		return campaignRepository.findById(id).orElseThrow(NotFoundException::new);

	}

	@Override
	public void deleteCampaign(Campaign campaign) {
		
		campaignRepository.delete(campaign);
	}

	
	@Override
	public List<Campaign> findTop5CampaignList() {
		
		return campaignRepository.findTop5ByOrderByIdDesc();
	}

}
