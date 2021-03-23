package com.bridgelabz;

import com.bridgelabz.CensusAnalyser;
import com.bridgelabz.CensusAnalyserException;
import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {
    public static final String INDIAN_STATE_CENSUS_FILE = "C:\\Users\\gopir\\IdeaProjects\\IndianStateCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE = "C:\\Users\\gopir\\IdeaProjects\\IndianStateCensusAnalyserProblem\\src\\main\\resources\\IndiaStateCode";;

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

}
