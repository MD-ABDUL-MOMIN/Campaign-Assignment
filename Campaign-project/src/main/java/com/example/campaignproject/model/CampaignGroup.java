package com.example.campaignproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "campaigngroup")
public class CampaignGroup implements Versionable{

	private static final long serialVersionUID = -2669552075624827806L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String description;

	@OneToMany(mappedBy = "campaignGroup" ,cascade = CascadeType.ALL)
	List<Campaign> campaignList = new ArrayList<Campaign>();
	
	@Version
	private Long version;
}
