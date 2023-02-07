package com.example.campaignproject.controller;

import com.example.campaignproject.commons.MultiResponseContent;
import com.example.campaignproject.data.CampaignGroupShort;
import com.example.campaignproject.model.CampaignGroup;
import com.example.campaignproject.service.CampaignGroupService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CampaignGroupController {


    @NonNull private final CampaignGroupService campaignGroupService;


    @GetMapping("/campaigngroups")
    public MultiResponseContent<CampaignGroupShort> getCampaignGroups() {
        return new MultiResponseContent<>(campaignGroupService.getAllCampaignGroup().stream()
                .map(campaignGroup -> CampaignGroupShort.builder()
                        .id(campaignGroup.getId())
                        .name(campaignGroup.getName()).build())
                .collect(Collectors.toList()));
    }


    @GetMapping("/campaigngroup/edit")
    public String modifyCampaignGroupById(@RequestParam("id") long id, Model model) {

        return null;

    }

    @PostMapping("/campaigngroup/edit/{id}")
    public String updateCampaignGroupById(@PathVariable long id, CampaignGroup campaignGroup) {
        return null;

    }


    @GetMapping("/campaigngroup/add")
    public String addCampaignGroup(Model model) {
        return null;
    }

    @PostMapping("/campaigngroup/add")
    public String saveCampaignGroup(@ModelAttribute CampaignGroup campaignGroup) {

        return null;
    }

}
