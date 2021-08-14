package com.example.testapp.campaign_group_package;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CampaignGroupController {

	@Autowired
	private CampaignGroupService campaignGroupService;

	/*************************** home page ***********************************/

	@GetMapping("/")
	public String showHome() {
		return "pages/home";

	}

	/***************************
	 * Show campaign group list
	 ***********************************/

	@GetMapping("/campaigngroup")
	public String getCampaignGroupPage(Model model) {

		List<CampaignGroupModel> campaignGroupList = new ArrayList<CampaignGroupModel>();
		campaignGroupList = campaignGroupService.getTop5CampaignGroup();
		model.addAttribute("campaignGroupList", campaignGroupList);
		return "pages/campaignGroup/campaigngroup_list";
	}

	/***************************
	 * Modify campaign Group
	 ***********************************/

	@GetMapping("/campaigngroup/edit")
	public String modifyCampaignGroupById(@RequestParam("id") long id, Model model) {

		CampaignGroupModel camGroupModel = campaignGroupService.findCampaignGroupById(id);
		model.addAttribute("editableId", id);
		model.addAttribute("campaigngroupModel", camGroupModel);
		return "pages/campaignGroup/edit_campaigngroup";

	}

	@PostMapping("/campaigngroup/edit/{id}")
	public String updateCampaignGroupById(@PathVariable long id, CampaignGroupModel campaignGroupModel) {

		campaignGroupService.updateCampaignGroup(campaignGroupModel);
		return "redirect:/campaigngroup";

	}

	/***************************
	 * add campaign Group
	 ***********************************/

	@GetMapping("/campaigngroup/add")
	public String addCampaignGroup(Model model) {
		CampaignGroupModel camModel = new CampaignGroupModel();
		model.addAttribute("campaigngroup", camModel);

		return "pages/campaignGroup/campaigngroup_adder";
	}

	@PostMapping("/campaigngroup/add")
	public String saveCampaignGroup(@ModelAttribute CampaignGroupModel campaignGroupModel) {

		campaignGroupService.saveCampaignGroup(campaignGroupModel);

		return "redirect:/campaigngroup";
	}

}
