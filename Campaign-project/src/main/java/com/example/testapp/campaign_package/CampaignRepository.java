package com.example.testapp.campaign_package;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends JpaRepository<CampaignModel, Long>{

	List<CampaignModel> findTop5ByOrderByIdDesc();
	
}
