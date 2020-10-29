package com.ipl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.opencsv.CSVException;

public class IPLAnalyserTest {
	public final String RunsCSV = "./Runs.csv";
	public final String WicketsCSV = "./Wickets.csv";
	IPLAnalyser ipl = null;
	int noOfEntries = 0;
	String sortedData = null;

	@Before
	public void setUp() {
		ipl = new IPLAnalyser();

	}

	@Test
	public void BattingAverage() {

		try {
			noOfEntries = ipl.loadMostRunsCSV(RunsCSV);
			sortedData = ipl.battingAverageSort();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Runs[] runs = new Gson().fromJson(sortedData, Runs[].class);
		Assert.assertEquals("MS Dhoni", runs[0].Player);
	}

	@Test
	public void StrikeRate() {

		try {
			noOfEntries = ipl.loadMostRunsCSV(RunsCSV);
			sortedData = ipl.StrikeRate();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}

		Runs[] censusCsv = new Gson().fromJson(sortedData, Runs[].class);
		Assert.assertEquals("Ishant Sharma", censusCsv[0].Player);
	}

	@Test
	public void MostFoursAndSixes() {

		try {
			noOfEntries = ipl.loadMostRunsCSV(RunsCSV);
			sortedData = ipl.SixesAndFours();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}

		Runs[] censusCsv = new Gson().fromJson(sortedData, Runs[].class);
		Assert.assertEquals("Andre Russell", censusCsv[100].Player);
	}

	@Test
	public void StrikeRateAndFouresSixes() {

		try {
			noOfEntries = ipl.loadMostRunsCSV(RunsCSV);
			sortedData = ipl.StrikerRateWithFouresSixes();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}

		Runs[] censusCsv = new Gson().fromJson(sortedData, Runs[].class);
		Assert.assertEquals("Andre Russell", censusCsv[0].Player);
	}

	@Test
	public void BattingAverageAndStrikeRate() {

		try {
			noOfEntries = ipl.loadMostRunsCSV(RunsCSV);
			sortedData = ipl.BattingAverageWithStrikeRate();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Runs[] censusCsv = new Gson().fromJson(sortedData, Runs[].class);
		Assert.assertEquals("MS Dhoni", censusCsv[0].Player);
	}

	@Test
	public void MostRunsAndBattingAverage() {

		try {
			noOfEntries = ipl.loadMostRunsCSV(RunsCSV);
			sortedData = ipl.MaximumRunsWithBattingAverage();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		Runs[] censusCsv = new Gson().fromJson(sortedData, Runs[].class);
		Assert.assertEquals("MS Dhoni", censusCsv[0].Player);
	}

	@Test
	public void MAximum100WithBestAverage() {
		int noOfEntries = 0;
		String data = null;
		try {
			noOfEntries = ipl.loadMostRunsCSV(RunsCSV);
			data = ipl.GreatBattingAverages();
		} catch (CSVException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(data);
		Runs[] censusCsv = new Gson().fromJson(data, Runs[].class);
		Assert.assertEquals("David Warner ", censusCsv[100].Player);
	}

}
