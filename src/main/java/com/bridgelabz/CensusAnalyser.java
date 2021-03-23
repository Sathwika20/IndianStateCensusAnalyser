package com.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CensusAnalyser {
    public static int loadCensusData(String filePathCSV) throws CensusAnalyserException {
        if (!filePathCSV.contains(".csv"))
            throw new CensusAnalyserException("This is invalid file type", CensusAnalyserException.ExceptionType.WRONG_FILE_TYPE);
        try (Reader reader = Files.newBufferedReader(Paths.get(filePathCSV))) {
            CsvToBean<IndiaCensusCSV> csvToBean = new CsvToBeanBuilder<IndiaCensusCSV>(reader)
                    .withType(IndiaCensusCSV.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<IndiaCensusCSV> indiaCensusCSVIterator = csvToBean.iterator();
            Iterable<IndiaCensusCSV> censusCSVIterable = () -> indiaCensusCSVIterator;
            return (int) StreamSupport.stream(censusCSVIterable.spliterator(), false).count();
        } catch (IOException exception) {
            throw new CensusAnalyserException(exception.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (RuntimeException exception) {
            if (exception.getMessage().contains("header")) {
                throw new CensusAnalyserException(exception.getMessage(), CensusAnalyserException.ExceptionType.WRONG_FILE_HEADER);
            }
            throw new CensusAnalyserException(exception.getMessage(), CensusAnalyserException.ExceptionType.WRONG_FILE_DELI_METER);
        }

    }
}
