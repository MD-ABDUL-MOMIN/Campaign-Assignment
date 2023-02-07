package com.example.campaignproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "campaign")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Campaign implements Versionable{

	private static final long serialVersionUID = 7622762532718559336L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private String description;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
	private Date startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
	private Date endDate;

	@ManyToOne
	@JoinColumn(name = "campaign_group_id", nullable = false)
	private CampaignGroup campaignGroup;

	@Version
	private Long version;

}
