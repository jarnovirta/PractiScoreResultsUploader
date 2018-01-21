package practiscore_results_uploader.domain;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stage {
	
	private Long id;	
	
	@JsonProperty("stage_uuid")
	private String uuid;
	
	@JsonProperty("stage_name")
	private String name;
	
	@JsonProperty("stage_number")
	private int stageNumber;
	
	@JsonProperty("stage_modifieddate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Calendar modifiedDate;

	@JsonProperty("stage_targets")
	private Target[] targets; 

	@JsonProperty("stage_poppers")
	private int poppers;
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStageNumber() {
		return stageNumber;
	}

	public void setStageNumber(int stageNumber) {
		this.stageNumber = stageNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Calendar modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Target[] getTargets() {
		return targets;
	}

	public void setTargets(Target[] targets) {
		this.targets = targets;
	}

	public int getPoppers() {
		return poppers;
	}

	public void setPoppers(int poppers) {
		this.poppers = poppers;
	}

}
