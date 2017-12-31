package practiscore_results_uploader.service;

import java.io.File;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import practiscore_results_uploader.domain.MatchScore;
import practiscore_results_uploader.practiscorefileparser.PractiScoreFileParser;

public class FileService {
	private static MatchScore matchScore = null;
	private static Long lastModified = null;
	
	public static MatchScore watchPractiScoreExportFileChange() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			while(true) {
				Thread.sleep(1000);
				System.out.println("Checking file");
				File exportFile = new File("scores.psc");
				Long fileModifiedTime = exportFile.lastModified();
				if (lastModified != null && lastModified.equals(fileModifiedTime)) continue;
				System.out.println("File modified!");
				String jsonString = PractiScoreFileParser.parse(exportFile);
				if (jsonString != null) {
					System.out.println("Sending JSON");
					matchScore = objectMapper.readValue(jsonString, new TypeReference<MatchScore>() {
					});
					System.out.println("File modified, time: " + lastModified);
					lastModified = fileModifiedTime;
					HttpService.sendMatchScore(matchScore);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return matchScore;
	}
}
