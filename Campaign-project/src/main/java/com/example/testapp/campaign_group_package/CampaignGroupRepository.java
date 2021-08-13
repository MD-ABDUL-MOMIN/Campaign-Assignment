package com.example.testapp.campaign_group_package;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignGroupRepository extends JpaRepository<CampaignGroupModel, Long> {
	
	CampaignGroupModel findById(long id);

	@Query(value = "select name from campaign_group", nativeQuery = true)
	List<String> findCampaigngroupNames();

}
