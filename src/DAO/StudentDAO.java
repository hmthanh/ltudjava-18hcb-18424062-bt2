/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JavaCode.CSVReader;
import Model.TbStudent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author sieus
 */
class SortByClasses implements Comparator<TbStudent> {

    // Used for sorting in ascending order of 
    // roll number 
    @Override
    public int compare(TbStudent a, TbStudent b) {
        return a.getClasses().compareTo(b.getClasses());
    }
}

public class StudentDAO extends AbstractDAO<TbStudent> {

    public List<TbStudent> getAll() {
        return super.getAll("TbStudent");
    }

    @Override
    public Boolean importFromFile(String filename) {
        List<List<String>> records = new ArrayList<>();
        String className = "";
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(filename), "UTF8"));
            className = br.readLine().replace(",", "").replaceAll("[^\\x00-\\x7F]", "");
            String header = br.readLine();
            records = CSVReader.readToBuffer(br);
        } catch (IOException e) {
            return false;
        }
        for (int i = 0; i < records.size(); i++) {
            List<String> metaData = records.get(i);
            String studentID = metaData.get(1);
            String fullName = metaData.get(2);
            String gender = metaData.get(3);
            String idCard = metaData.get(4);
            TbStudent item = new TbStudent(studentID, fullName, gender, idCard, className);
            super.add(item);
        }

        return true;
    }

    @Override
    public List<TbStudent> filter(String filter) {
        List<TbStudent> list = super.getAll("TbStudent");
        List<TbStudent> result = new ArrayList();
        Stream<TbStudent> stream = list.stream().filter((TbStudent item) -> {
            if (item == null) {
                return false;
            } else if (item.getClasses() != null) {
                return item.getClasses().equals(filter);
            } else {
                return false;
            }
        });
        result = stream.collect(Collectors.toList());
        return result;
    }

    public List<String> getClasses() {
        List<TbStudent> list = super.getAll("TbStudent");
        Collections.sort(list, new SortByClasses());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i).getClasses());
        }
        return new ArrayList<>(set);
    }
}
