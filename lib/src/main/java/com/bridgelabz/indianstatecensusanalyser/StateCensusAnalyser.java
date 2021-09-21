package com.bridgelabz.indianstatecensusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.bridgelabz.indianstatecensusanalyser.CensusAnalyserException.ExceptionType;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.util.Iterator;
public class StateCensusAnalyser {
	
	public int loadIndiaCensusData(String csvFilePath)throws CensusAnalyserException {
		
		int numberOfEntries = 0;
		try {
			if(!csvFilePath.contains(".csv")) {
				throw new CensusAnalyserException("Enter csv file" , ExceptionType.CENSUS_INCORRECT_FILE_FORMAT);
			}
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
			throw new CensusAnalyserException(e.getMessage(), ExceptionType.CENSUS_FILE_PROBLEM);
		}catch (RuntimeException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
        }
		return numberOfEntries;
	}

}
