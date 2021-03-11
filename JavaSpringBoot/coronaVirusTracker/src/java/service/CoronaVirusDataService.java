package com.coronavirus.coronatrack.service;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.coronavirus.coronatrack.model.LocationStats;

@Service
public class CoronaVirusDataService {

	private static String VIRUS_DATAURL="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/03-04-2021.csv";
	
	private List<LocationStats> allStats = new ArrayList<>();

	public List<LocationStats> getAllStats() {
		return allStats;
	}

	@PostConstruct
	@Scheduled(cron = "* * 1 * * *")
	public void fetchVirusData() throws IOException, InterruptedException {
		List<LocationStats> newStats = new ArrayList<>();
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(VIRUS_DATAURL))
			.build();
		
		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		System.out.println("HTTP: "+httpResponse.body());
		
		StringReader csvBodyReader = new StringReader(httpResponse.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
		
		for (CSVRecord record : records) {
			
			LocationStats locationStat = new LocationStats();
			
			locationStat.setState(record.get("Province_State"));
			locationStat.setCountry(record.get("Country_Region"));
			locationStat.setLatestTotalCases(Integer.parseInt(record.get("Confirmed")));
			locationStat.setDeaths(record.get("Deaths"));
			locationStat.setRecovered(record.get("Recovered"));
			locationStat.setActive(record.get("Active"));
			
			newStats.add(locationStat);
		}
		this.allStats=newStats;
	}
}