package com.example.testapp.campaign_package;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.testapp.campaign_group_package.CampaignGroupModel;

@Controller
public class CampaignController {
	
	@Autowired
	private CampaignService campaignService;
	
	@GetMapping("/campaign")
	public String showCampaignList(Model model) {
		
		List<CampaignModel> campaigns = new ArrayList<CampaignModel>();
		campaigns = campaignService.findCampaignList();
		model.addAttribute("campaigns", campaigns);
		
		return "pages/campaign_list";
	}
	
	
	
	///New campaign creation get and post mapping

	
	@GetMapping("/campaign/add")
	public String addCampaign(Model model) {
		
		CampaignModel camModel = new CampaignModel();
		model.addAttribute("campaignModel", camModel);
		List<CampaignGroupModel> campaignGroupList = new ArrayList<CampaignGroupModel>();
		campaignGroupList = campaignService.getCampaignGroups();
		
		model.addAttribute("campaignGroups", campaignGroupList);
	

		return "pages/campaign_adder";
	}
	
	
	
	@PostMapping("/campaign/add")
	public String saveCampaignGroup(@ModelAttribute CampaignModel campaignModel,@ModelAttribute  CampaignGroupModel campaignGroupModel) {
		
		System.out.println("print "+campaignModel.getStartDate());
		
		campaignModel.setCampaignGroupModel(campaignGroupModel);
		
		campaignService.saveCampaign(campaignModel);

		return "redirect:/campaign";
	}
	
	


}
