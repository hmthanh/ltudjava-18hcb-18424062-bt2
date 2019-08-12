/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JavaCode.CSVReader;
import JavaCode.HibernateUtil;
import Model.TbSubject;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sieus
 */
public class SubjectDAO {

    public Session session = null;

    public List<TbSubject> getAll() {
        List<TbSubject> ds = null;
        if (session == null) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            String hql = "from TbSubject";
            ds = session.createQuery(hql).list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
    
    public List<String> getAllClass(){
        List<TbSubject> list = getAll();
        Set<String> result = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(i).getClassId());
        }
        
        String[] arr = result.toArray(new String[0]);
        return Arrays.asList(arr);
    }
    public List<TbSubject> getSubjectByClass(String className) {
        List<TbSubject> ds = getAll();
        List<TbSubject> result = new ArrayList<>();
        for (int i = 0; i < ds.size(); i++) {
            Boolean isClass = ds.get(i).getClassId()== null ? className == null : ds.get(i).getClassId().equals(className);
            if (isClass) {
                result.add(ds.get(i));
            }
        }
        return result;
    }
//
//    public Boolean addSubject(String stdID, String fullName, String gender, String IDCard, String classes) {
//        Session session = null;
//        session = HibernateUtil.getSessionFactory().openSession();
//        if (getSubjectByID(stdID) != null) {
//            return false;
//        }
//        TbSubject std = new TbSubject();
//        std.setSubjectId(stdID);
//        std.setFullname(fullName);
//        std.setGender(gender);
//        std.setIdcard(IDCard);
//        std.setClasses(classes);
//        Transaction transaction = null;
//        try {
//            transaction = session.beginTransaction();
//            session.save(std);
//            transaction.commit();
//        } catch (HibernateException ex) {
//            transaction.rollback();
//            System.err.println(ex);
//        } finally {
//            session.close();
//        }
//        return true;
//    }
//
    public Boolean addListSubject(List<TbSubject> list) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            for (int i = 0; i < list.size(); i++) {
                TbSubject std = list.get(i);
                session.save(std);
            }
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }

    public Boolean importFromFile(String filename) {
        List<List<String>> records = new ArrayList<>();
        String className = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(filename), "UTF8"));
            className = br.readLine().replace(",", "").replaceAll("[^\\x00-\\x7F]", "");
            String header = br.readLine();
            records = CSVReader.readToBuffer(br);
        } catch (IOException e) {
            return false;
        }
        List<TbSubject> listStd = new ArrayList<>();
        for (int i = 0; i < records.size(); i++) {
            List<String> metaData = records.get(i);
            String stdID = metaData.get(1);
            String name = metaData.get(2);
            String room = metaData.get(3);
            TbSubject sbj = new TbSubject(stdID, name, room, className);
            listStd.add(sbj);
        }

        return addListSubject(listStd);
    }
}
