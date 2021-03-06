package practiscore_results_uploader.service;

import java.io.File;
import java.nio.file.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import practiscore_results_uploader.domain.Match;
import practiscore_results_uploader.domain.MatchScore;
import practiscore_results_uploader.practiscorefileparser.PractiScoreExportFileDataObject;
import practiscore_results_uploader.practiscorefileparser.PractiScoreFileParser;

public class FileService {
	private static Match match = null;
	private static MatchScore matchScore = null;
	
	private static Long lastModified = null;
	
	public static MatchScore watchPractiScoreExportFileChange() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
//			while(true) {
//				Thread.sleep(1000);
				System.out.println("Checking file");
				File exportFile = new File("scores.psc");
				
				Long fileModifiedTime = exportFile.lastModified();
//				if (lastModified != null && lastModified.equals(fileModifiedTime)) continue;
				System.out.println("File modified!");
				PractiScoreExportFileDataObject exportFileDataObject = PractiScoreFileParser.parse(exportFile);
				if (exportFileDataObject != null) {
					System.out.println("Converting to Java objects");
					match = objectMapper.readValue(exportFileDataObject.getMatchData(), new TypeReference<Match>() {
					});
					matchScore = objectMapper.readValue(exportFileDataObject.getScoreData(), new TypeReference<MatchScore>() {
					});
					System.out.println("Sending JSON");
					System.out.println("File modified, time: " + lastModified);
					lastModified = fileModifiedTime;
					HttpService.sendMatchData(match);
					HttpService.sendMatchScore(matchScore);
					
				}
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return matchScore;
	}
	public static void testDirectoryListing() {
		try {
		File currentDir = new File("");
		String absolutePath = currentDir.getAbsolutePath();
		Files.list(new File(absolutePath).toPath())
        .limit(10)
        .forEach(path -> {
            System.out.println(path);
        });
		}
		catch (Exception e) {
			
		}
	}
}
