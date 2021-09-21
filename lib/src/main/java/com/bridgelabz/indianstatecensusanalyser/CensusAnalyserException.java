package com.bridgelabz.indianstatecensusanalyser;

public class CensusAnalyserException extends Exception{
	
	enum ExceptionType{
		CENSUS_FILE_PROBLEM,
		CENSUS_INCORRECT_FILE_FORMAT,
		WRONG_FILE_PATH,
		CSV_FILE_INTERNAL_ISSUES
	}
	
	ExceptionType type;
	
	 public CensusAnalyserException(String message, ExceptionType type) {
		 super(message);
	     this.type = type;
	   } 
}
