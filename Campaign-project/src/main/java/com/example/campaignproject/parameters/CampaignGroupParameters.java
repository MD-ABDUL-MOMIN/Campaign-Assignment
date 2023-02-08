package com.example.campaignproject.parameters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampaignGroupParameters {
    private Long groupId;
    private String name;
    private String description;

}
