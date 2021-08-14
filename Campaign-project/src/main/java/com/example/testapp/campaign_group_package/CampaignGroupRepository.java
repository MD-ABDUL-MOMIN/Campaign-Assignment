package com.example.testapp.campaign_group_package;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignGroupRepository extends JpaRepository<CampaignGroupModel, Long> {
	
	
	CampaignGroupModel findById(long id);
	
	List<CampaignGroupModel> findTop5ByOrderByIdDesc();


}
