/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JavaCode.CSVReader;
import Model.TbSubject;
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
class SortByName implements Comparator<TbSubject> {

    // Used for sorting in ascending order of 
    // roll number 
    @Override
    public int compare(TbSubject a, TbSubject b) {
        return a.getSubjectId().compareTo(b.getSubjectId());
    }
}

public class SubjectDAO extends AbstractDAO<TbSubject> {

    public List<TbSubject> getAll() {
        return super.getAll("TbSubject");
    }

    @Override
    public Boolean add(TbSubject item) {
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
            String subjectId = metaData.get(1);
            String subjectName = metaData.get(2);
            String room = metaData.get(3);
            TbSubject sub = new TbSubject(subjectId, subjectName, room, className);
            super.add(sub);
        }

        return true;
    }

    @Override
    public List<TbSubject> filter(String filter) {
        List<TbSubject> list = super.getAll("TbSubject");
        List<TbSubject> result = new ArrayList();
        Stream<TbSubject> stream = list.stream().filter((TbSubject item) -> {
            if (item == null) {
                return false;
            } else if (item.getClassId() != null) {
                return item.getClassId().equals(filter);
            } else {
                return false;
            }
        });
        result = stream.collect(Collectors.toList());
        return result;
    }

    public List<String> getSubject() {
        List<TbSubject> list = super.getAll("TbSubject");
        Collections.sort(list, new SortByName());
        Set<String> set = new HashSet<>();
//        for (int i = 0; i < list.size(); i++) {
//            set.add(list.get(i).getSubjectId());
//        }
        return new ArrayList<>(set);
    }

    public List<String> getClasses() {
        List<TbSubject> list = super.getAll("TbSubject");
        Collections.sort(list, new SortByName());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i).getClassId());
        }
        return new ArrayList<>(set);
    }
}
