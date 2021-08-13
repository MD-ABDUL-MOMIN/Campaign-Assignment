package com.example.testapp.campaign_group_package;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CampaignGroupController {

	@Autowired
	CampaignGroupService campaignGroupService;

	@GetMapping("/campaigngroup")
	public String getCampaignGroupPage(Model model) {

		List<CampaignGroupModel> campaignGroupList = new ArrayList<CampaignGroupModel>();
		campaignGroupList = campaignGroupService.getAllCampaignGroup();
		model.addAttribute("campaignGroupList", campaignGroupList);
		return "pages/campaign_group_page";
	}

	
	@GetMapping("/campaigngroup/edit")
	public String modifyCampaignGroupById(@RequestParam("id") long id, Model model) {
		
		CampaignGroupModel camGroupModel = campaignGroupService.findCampaignGroupById(id);
		model.addAttribute("campaigngroup", camGroupModel);
		return "pages/campaign_group_form";
		
	}

	@PostMapping("/campaigngroup/edit")
	public String updateCampaignGroupById(CampaignGroupModel campaignGroupModel) {

		
		campaignGroupService.saveOrUpdateCampaignGroup(campaignGroupModel);
		return "redirect:/campaigngroup";

	}

	@GetMapping("/campaigngroup/add")
	public String addCampaignGroup(Model model) {
		CampaignGroupModel camModel = new CampaignGroupModel();
		model.addAttribute("campaigngroup", camModel);

		return "pages/campaign_group_input_form";
	}
	
}
