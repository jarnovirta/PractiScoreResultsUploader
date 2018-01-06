package practiscore_results_uploader.domain;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stage {
	@JsonProperty("stage_uuid")
	private String uuid;
	
	@JsonProperty("stage_name")
	private String name;
	
	@JsonProperty("stage_number")
	private int stageNumber;
	
	@JsonProperty("stage_modifieddate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Calendar modifiedDate;

	
	
}
