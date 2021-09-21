/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.bridgelabz.indianstatecensusanalyser;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.bridgelabz.indianstatecensusanalyser.CSVStateCensus;

import static org.junit.Assert.*;

import org.junit.Assert;

public class CensusAnalyserExceptionTest {
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndianStatesCensus.csv";
	private static final String CSV_WRONG_FILE_PATH="./IndianStatesCensus.csv";
	private static final String INCORRECT_FILE_FORMAT = "./src/test/resources/CensusDataWrongType.txt";
	
    @Test public void loadIndiaCensusData_givenIndianCensusCSVFile_returnsCorrectNumberRecords() {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29, numOfRecords);
        } catch (CensusAnalyserException e) {
        }
        
    }
    
    @Test public void loadIndiaCensusData_givenWrongPath_ShouldThrowException() {
    	try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(CSV_WRONG_FILE_PATH);
            
        } catch (CensusAnalyserException e) {
        	Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_PATH, e.type);
        }
    }
    @Test 
    public void loadIndiaCensusData_WithWrongFileType_ShouldThrowException() {
        try {
        	StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INCORRECT_FILE_FORMAT);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT, e.type);
        }
    }
   
}
