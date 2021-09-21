package com.bridgelabz.indianstatecensusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.util.Iterator;
public class StateCensusAnalyser {
	
	public int loadIndiaCensusData(String csvFilePath) {
		
		int numberOfEntries = 0;
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder=new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVStateCensus.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();
			Iterator<CSVStateCensus> censusCSVIterator=csvToBean.iterator();
	
    		while(censusCSVIterator.hasNext()) {
    			numberOfEntries++;
    			CSVStateCensus censusData = censusCSVIterator.next();
    		}
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return numberOfEntries;
	}

}
