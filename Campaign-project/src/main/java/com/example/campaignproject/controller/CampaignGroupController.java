package com.example.campaignproject.controller;

import com.example.campaignproject.commons.MultiResponseContent;
import com.example.campaignproject.commons.ResponseContent;
import com.example.campaignproject.data.CampaignGroupShort;
import com.example.campaignproject.model.CampaignGroup;
import com.example.campaignproject.parameters.CampaignGroupParameters;
import com.example.campaignproject.service.CampaignGroupService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CampaignGroupController {


    @NonNull private final CampaignGroupService campaignGroupService;


    @GetMapping("/campaigngroups")
    public MultiResponseContent<CampaignGroupShort> getCampaignGroups() {
        return new MultiResponseContent<>(campaignGroupService.getAllCampaignGroup().stream()
                .map(campaignGroup -> CampaignGroupShort.builder()
                        .id(campaignGroup.getId())
                        .name(campaignGroup.getName())
                        .build())
                .collect(Collectors.toList()));
    }


    @DeleteMapping("/campaigngroup/delete")
    public void deleteCampaignGroup(@RequestBody CampaignGroupParameters parameters, BindingResult bindingResult) {
        campaignGroupService.removeGroup(parameters.getGroupId());
    }

    @PostMapping("/campaigngroup/edit/{id}")
    public String updateCampaignGroupById(@PathVariable long id, CampaignGroup campaignGroup) {
        return null;
    }


    @PostMapping("/campaigngroup/add")
    public ResponseContent<CampaignGroup> addCampaignGroup(@RequestBody CampaignGroupParameters parameters, BindingResult bindingResult) {
        CampaignGroup campaignGroup = CampaignGroup.builder()
                .name(parameters.getName())
                .description(parameters.getDescription())
                .build();
        return new ResponseContent<>(campaignGroupService.saveCampaignGroup(campaignGroup));
    }
}
