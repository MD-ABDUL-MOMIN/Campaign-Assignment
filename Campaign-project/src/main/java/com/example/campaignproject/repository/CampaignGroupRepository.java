package com.example.campaignproject.repository;

import java.util.List;

import com.example.campaignproject.model.CampaignGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignGroupRepository extends JpaRepository<CampaignGroup, Long> {
	
	
	CampaignGroup findById(long id);
	
	List<CampaignGroup> findTop5ByOrderByIdDesc();


}
