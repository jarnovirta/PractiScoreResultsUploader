package practiscore_results_uploader.practiscorefileparser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import practiscore_results_uploader.domain.MatchScore;
import practiscore_results_uploader.domain.StageScore;

public class PractiScoreFileParser {
	public static MatchScore loadScoreData() {
		MatchScore matchScore = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			matchScore = objectMapper.readValue(readScoreDataFromFile(), new TypeReference<MatchScore>() {
			});
//			System.out.println("Read match " + matchScore.getMatchId());
//			System.out.println("StageScores count: " + matchScore.getStageScores().size());
//			for (StageScore stageScore : matchScore.getStageScores()) {
//				System.out.println("stage" + stageScore.getStageNumber() + " : " + stageScore.getScoreCards().size()
//						+ " scorecards");
//				System.out.println(
//						"First scorecard modified " + stageScore.getScoreCards().get(0).getModified().getTime());
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return matchScore;
	}

	private static String readScoreDataFromFile() throws IOException {
		String fileContentString = null;
		try {
			ZipFile zipFile = new ZipFile("scores.psc");
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				if (entry.getName().equals("match_scores.json")) {
					InputStream inputStream = zipFile.getInputStream(entry);
					fileContentString = IOUtils.toString(inputStream, "utf-8");
					inputStream.close();
					return fileContentString;
				}
			}
			zipFile.close();
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
}
