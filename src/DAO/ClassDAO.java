/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JavaCode.CSVReader;
import Model.TbClasses;
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
class SortBySbj implements Comparator<TbClasses> {

    // Used for sorting in ascending order of 
    // roll number 
    @Override
    public int compare(TbClasses a, TbClasses b) {
        return a.getSubjectId().compareTo(b.getSubjectId());
    }
}

public class ClassDAO extends AbstractDAO<TbClasses> {

    public List<TbClasses> getAll() {
        return super.getAll("TbClasses");
    }

    @Override
    public Boolean add(TbClasses item) {
        return super.add(item); //To change body of generated methods, choose Tools | Templates.
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
            TbClasses item = new TbClasses(studentID, fullName, gender, idCard, className);
            super.add(item);
        }

        return true;
    }

    @Override
    public List<TbClasses> filter(String filter) {
        List<TbClasses> list = super.getAll("TbClasses");
        List<TbClasses> result = new ArrayList();
        Stream<TbClasses> stream = list.stream().filter((TbClasses item) -> {
            if (item == null) {
                return false;
            } else if (item.getSubjectId() != null) {
                return item.getSubjectId().equals(filter);
            } else {
                return false;
            }
        });
        result = stream.collect(Collectors.toList());
        return result;
    }

    public List<String> getClasses() {
        List<TbClasses> list = super.getAll("TbClasses");
        Collections.sort(list, new SortBySbj());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i).getSubjectId());
        }
        return new ArrayList<>(set);
    }

    public List<TbClasses> removeFromIdx(int[] removeArray, String className) {
        List<TbClasses> list = filter(className);
        for (int i = 0; i < removeArray.length; i++) {
            TbClasses item = list.get(removeArray[i]);
            list.remove(removeArray[i]);
            super.remove(item);
        }

        return list;
    }
}
