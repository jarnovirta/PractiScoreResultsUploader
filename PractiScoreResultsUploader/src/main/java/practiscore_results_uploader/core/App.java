package practiscore_results_uploader.core;

import practiscore_results_uploader.service.FileService;

public class App {
	public static void main(String[] args) {
		System.out.println("Starting");
		FileService.watchPractiScoreExportFileChange();
	}
}
