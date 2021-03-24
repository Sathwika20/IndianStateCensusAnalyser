package com.bridgelabz;

import com.bridgelabz.CensusAnalyser;
import com.bridgelabz.CensusAnalyserException;
import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {
    public static final String INDIAN_STATE_CENSUS_FILE = "C:\\Users\\gopir\\IdeaProjects\\IndianStateCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE = "C:\\Users\\gopir\\IdeaProjects\\IndianStateCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCode";;
    private static final String WRONG_CSV_FILE_TYPE = "C:\\Users\\gopir\\IdeaProjects\\IndianStateCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCensusData.txt";;
    private static final String WRONG_CSV_FILE_DELI_METER = "C:\\Users\\gopir\\IdeaProjects\\IndianStateCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCensusDataDelimiter.csv";;
    private static final String INDIAN_STATE_CODE_FILE = "C:\\Users\\gopir\\IdeaProjects\\IndianStateCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCode.csv";;
    private static final String CODE_WRONG_CSV_FILE = "C:\\Users\\Ramesh\\IdeaProjects\\IndianStateCensusAnalyserProblem\\src\\main\\resources\\IndiaState.csv";
    private static final String CODE_WRONG_CSV_FILE_TYPE = "C:\\Users\\Ramesh\\IdeaProjects\\IndianStateCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCode.txt";;

    @Test
    public void GivenTheStateCodesCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() {
        try {
            int count = CensusAnalyser.loadCensusData(INDIAN_STATE_CENSUS_FILE);
            Assert.assertEquals(29, count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndiaStateCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser.loadCensusData(WRONG_CSV_FILE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
    @Test
    public void givenIndiaCensusData_WithWrongFileType_ShouldThrowException() {
        try {
            CensusAnalyser.loadCensusData(WRONG_CSV_FILE_TYPE);
        } catch (CensusAnalyserException e) {
            System.out.println(e.type);
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE,e.type);
        }
    }
    @Test
    public void givenIndiaCensusData_WithWrongFileDeliMeter_ShouldThrowException() {
        try {
            CensusAnalyser.loadCensusData(WRONG_CSV_FILE_DELI_METER);
        } catch (CensusAnalyserException e) {
            System.out.println(e.type);
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_DELI_METER,e.type);
        }
    }
    @Test
    public void givenIndiaCensusData_WithWrongFileHeader_ShouldThrowException() {
        try {
            CensusAnalyser.loadCensusData(INDIAN_STATE_CODE_FILE);
        } catch (CensusAnalyserException e) {
            System.out.println(e.type);
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_HEADER, e.type);
        }
    }
    @Test
    public void givenIndianStateCodeCSVFile_ReturnsCorrectRecords() {
        try {
            int count = CensusAnalyser.loadCodeData(INDIAN_STATE_CODE_FILE);
            System.out.println(count);
            Assert.assertEquals(37, count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndiaStateCodeData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser.loadCodeData(CODE_WRONG_CSV_FILE);
        } catch (CensusAnalyserException e) {
            System.out.println(e.type);
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CODE_FILE_PROBLEM, e.type);
        }
    }
    @Test
    public void givenIndiaStateCodeData_WithWrongFileType_ShouldThrowException() {
        try {
            CensusAnalyser.loadCodeData(CODE_WRONG_CSV_FILE_TYPE);
        } catch (CensusAnalyserException e) {
            System.out.println(e.type);
            Assert.assertEquals(CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE, e.type);
        }
    }

}
