package com.bridgelabz;

public class CensusAnalyserException extends Exception {
    public ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public enum ExceptionType {
        CENSUS_FILE_PROBLEM,WRONG_FILE_TYPE
    }
}
