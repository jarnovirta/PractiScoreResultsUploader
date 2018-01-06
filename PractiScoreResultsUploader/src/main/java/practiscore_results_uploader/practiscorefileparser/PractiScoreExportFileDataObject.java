package practiscore_results_uploader.practiscorefileparser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PractiScoreExportFileDataObject {
	private String matchData;
	private String scoreData;
	
	public String getMatchData() {
		return matchData;
	}
	public void setMatchData(String matchData) {
		this.matchData = matchData;
	}
	public String getScoreData() {
		return scoreData;
	}
	public void setScoreData(String scoreData) {
		this.scoreData = scoreData;
	}
	
}
