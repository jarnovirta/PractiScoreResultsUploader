package practiscore_results_uploader.practiscorefileparser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;

public class PractiScoreFileParser {

	public static PractiScoreExportFileDataObject parse(File file) {
		PractiScoreExportFileDataObject dataObject = new PractiScoreExportFileDataObject();
		try {
			ZipFile zipFile = new ZipFile(file);
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				String json;
				ZipEntry entry = entries.nextElement();
				InputStream inputStream = zipFile.getInputStream(entry);
				json = IOUtils.toString(inputStream, "utf-8");
				inputStream.close();
				if (entry.getName().equals("match_def.json")) {
					dataObject.setMatchData(json);
				}
				if (entry.getName().equals("match_scores.json")) {
					dataObject.setScoreData(json);
				}
			}
			zipFile.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dataObject;
	}

}
