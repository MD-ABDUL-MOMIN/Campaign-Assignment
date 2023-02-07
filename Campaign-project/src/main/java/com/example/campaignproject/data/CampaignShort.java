package com.example.campaignproject.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CampaignShort {
    Long id;
    String name;
    String description;
    String groupName;

}
