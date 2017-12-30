package practiscore_results_uploader.core;

import practiscore_results_uploader.domain.MatchScore;
import practiscore_results_uploader.practiscorefileparser.PractiScoreFileParser;
import practiscore_results_uploader.service.HttpService;

public class App {
	public static void main(String[] args) {
		System.out.println("Starting");
		MatchScore matchScore = PractiScoreFileParser.loadScoreData();
		HttpService.sendMatchScore(matchScore);
	}
}
