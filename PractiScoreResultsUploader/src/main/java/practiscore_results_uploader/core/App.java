package practiscore_results_uploader.core;

import practiscore_results_uploader.practiscorefileparser.PractiScoreFileParser;

public class App {
	public static void main(String[] args) {
		System.out.println("Starting");
		PractiScoreFileParser.loadScoreData();
	}
}
