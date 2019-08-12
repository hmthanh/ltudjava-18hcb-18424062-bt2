/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JavaCode.CSVReader;
import JavaCode.HibernateUtil;
import Model.TbStudent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sieus
 */
public class StudentDAO {

    public Session session = null;

    public List<TbStudent> getAll() {
        List<TbStudent> ds = null;
        if (session == null) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        try {
            String hql = "from TbStudent";
            ds = session.createQuery(hql).list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
    
    public List<String> getAllClass(){
        List<TbStudent> list = getAll();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(i).getClasses());
        }
        
        return result;
    }
    public List<TbStudent> getStudentByClass(String className) {
        List<TbStudent> ds = getAll();
        List<TbStudent> result = new ArrayList<>();
        for (int i = 0; i < ds.size(); i++) {
            Boolean isClass = ds.get(i).getClasses() == null ? className == null : ds.get(i).getClasses().equals(className);
            if (isClass) {
                result.add(ds.get(i));
            }
        }
        return result;
    }

    public TbStudent getStudentByID(String stdID) {
        List<TbStudent> ds = getAll();
        List<TbStudent> result = null;
        for (int i = 0; i < ds.size(); i++) {
            TbStudent std = ds.get(i);
            Boolean trueID = std.getStudentId() == null ? stdID == null : std.getStudentId().equals(stdID);
            if (trueID) {
                return std;
            }
        }
        return null;
    }

    public Boolean addStudent(String stdID, String fullName, String gender, String IDCard, String classes) {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        if (getStudentByID(stdID) != null) {
            return false;
        }
        TbStudent std = new TbStudent();
        std.setStudentId(stdID);
        std.setFullname(fullName);
        std.setGender(gender);
        std.setIdcard(IDCard);
        std.setClasses(classes);
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(std);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }

    public Boolean addListStudent(List<TbStudent> list) {
        if (session == null) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            for (int i = 0; i < list.size(); i++) {
                TbStudent std = list.get(i);
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
            className = br.readLine().replace(",", "");//.replaceAll("[^\\x00-\\x7F]", "");
            String header = br.readLine();
            records = CSVReader.readToBuffer(br);
        } catch (IOException e) {
            return false;
        }
        StudentDAO dao = new StudentDAO();
        List<TbStudent> listStd = new ArrayList<>();
        for (int i = 0; i < records.size(); i++) {
            List<String> metaData = records.get(i);
            String no = metaData.get(0);
            String stdID = metaData.get(1);
            String fullName = metaData.get(2);
            String gender = metaData.get(3);
            String IDCard = metaData.get(4);
            TbStudent std = new TbStudent(stdID, fullName, gender, IDCard, className);
            listStd.add(std);
        }

        return addListStudent(listStd);
    }
}
