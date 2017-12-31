package practiscore_results_uploader.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import practiscore_results_uploader.domain.MatchScore;


public class HttpService {
	
	private static String url = "http://92.168.43.105:8080/IPSCResultServer/api/matches";
	
	public static void sendMatchScore(MatchScore matchScore) {
	ObjectMapper objectMapper = new ObjectMapper();
	try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
		
    	String JSON = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(matchScore);
    	HttpPost request = new HttpPost(url);
        StringEntity params = new StringEntity(JSON);
        request.addHeader("content-type", "application/json");
        request.setEntity(params);
        System.out.println("Sending JSON");
        HttpResponse response = httpClient.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);            
        System.out.println("JSON sent. Response : " + responseString);
        
    } catch (Exception ex) {
    	ex.printStackTrace();
    	
    }
	}
}
