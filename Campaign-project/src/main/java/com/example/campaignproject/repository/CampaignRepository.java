package com.example.campaignproject.repository;

import java.util.List;

import com.example.campaignproject.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long>{

	List<Campaign> findTop5ByOrderByIdDesc();
	
}
