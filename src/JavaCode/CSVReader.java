/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sieus
 * @param <T>
 */
public class CSVReader<T> {

    public static final String COMMA_DELIMITER = ",";

    public static List<List<String>> readToBuffer(BufferedReader buffReader) throws IOException {
        List<List<String>> records = new ArrayList<>();
        String line;
        while ((line = buffReader.readLine()) != null) {

            String[] values = line.split(COMMA_DELIMITER);
            records.add(Arrays.asList(values));
        }

        return records;
    }

}
