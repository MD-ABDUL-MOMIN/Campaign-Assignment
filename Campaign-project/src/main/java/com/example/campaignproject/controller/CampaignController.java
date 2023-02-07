package com.example.campaignproject.controller;

import com.example.campaignproject.commons.MultiResponseContent;
import com.example.campaignproject.data.CampaignShort;
import com.example.campaignproject.model.Campaign;
import com.example.campaignproject.parameters.CampaignParameters;
import com.example.campaignproject.service.CampaignGroupService;
import com.example.campaignproject.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CampaignController {

    @NonNull private final CampaignService campaignService;
    @NonNull private final CampaignGroupService campaignGroupService;

    @GetMapping("/campaigns")
    public MultiResponseContent<CampaignShort> getCampaigns() {
        List<Campaign> campaigns = campaignService.findTop5CampaignList();
        return new MultiResponseContent<>(campaigns.stream()
                .map(campaignModel -> CampaignShort.builder()
                        .id(campaignModel.getId())
                        .name(campaignModel.getName())
                        .description(campaignModel.getDescription())
                        .groupName(campaignModel.getCampaignGroup().getName())
                        .build())
                .collect(Collectors.toList()));

    }


    @PostMapping("/campaign/add")
    public void addCampaign(@RequestBody CampaignParameters campaignParameters, BindingResult bindingResult) {
        Campaign newCampaign = Campaign.builder()
                .campaignGroup(campaignGroupService.findCampaignGroupById(campaignParameters.getGroupId()))
                .description(campaignParameters.getDescription())
                .name(campaignParameters.getName())
                .build();
        campaignService.saveCampaign(newCampaign);
    }

    @DeleteMapping("/campaign/delete")
    public void deleteCampaign(@RequestBody CampaignParameters campaignParameters, BindingResult bindingResult) {
        Campaign newCampaign = campaignService.findCampaignById(campaignParameters.getCampaignId());
        campaignService.deleteCampaign(newCampaign);
    }
}
