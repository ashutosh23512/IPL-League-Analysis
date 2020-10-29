package com.ipl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.opencsv.CSVException;

public class IPLAnalyserTestBowling {
	public final String WicketsCSV = "Wkts.csv";
	IPLAnalyser ipl = null;
	int noOfEntries = 0;
	String sortedData = null;

	@Before
	public void setUp() {
		ipl = new IPLAnalyser();

	}

	@Test
	public void givenWicketsCSVFile_ShouldSortAccordingBowlingAverage() {
		int noOfEntries = 0;
		String sortedData = null;
		try {
			noOfEntries = ipl.loadMostWktsCSV(WicketsCSV);
			sortedData = ipl.MaximumBowlingAverage();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(sortedData);
		Wickets[] censusCsv = new Gson().fromJson(sortedData, Wickets[].class);
		Assert.assertEquals("Krishnappa Gowtham", censusCsv[0].Player);
	}

}
