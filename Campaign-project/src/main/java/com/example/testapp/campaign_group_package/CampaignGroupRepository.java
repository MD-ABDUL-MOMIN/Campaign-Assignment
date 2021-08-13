package com.example.testapp.campaign_group_package;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignGroupRepository extends JpaRepository<CampaignGroupModel, Long> {
	
	CampaignGroupModel findById(long id);

}
