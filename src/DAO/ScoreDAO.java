/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JavaCode.CSVReader;
import JavaCode.HibernateUtil;
import Model.TbScore;
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
public class ScoreDAO {

    public List<TbScore> getAll() {
        Session session = null;
        List<TbScore> ds = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from TbScore";
            ds = session.createQuery(hql).list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    public List<String> getAllSubject() {
        List<TbScore> list = getAll();
        Set<String> result = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(i).getSubjectId());
        }
        String[] arr = result.toArray(new String[0]);
        return Arrays.asList(arr);
    }

    public List<TbScore> getAllByFilter(Integer filter, String subject) {
        List<TbScore> list = getAll();
        List<TbScore> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            TbScore score = list.get(i);
            if (score.getSubjectId().equals(subject)) {
                switch (filter) {
                    case 0:
                    default:
                        result.add(score);
                        break;
                    case 1:
                        if (score.getAvgScore() >= (float) 5) {
                            result.add(score);
                        }
                        break;
                    case 2:
                        if (score.getAvgScore() < (float) 5) {
                            result.add(score);
                        }
                        break;
                }
            }
        }
        return result;
    }
    
    public List<TbScore> getScoreByStudentID(String subject,String stdID) {
        List<TbScore> list = getAll();
        List<TbScore> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            TbScore score = list.get(i);
            boolean trueStd = score.getStudentId().equals(stdID);
            boolean trueSbj = score.getSubjectId().equals(subject);
            if (!trueSbj || !trueStd) {
            } else {
                result.add(score);
            }
        }

        return result;
    }

    public String[] statistic(List<TbScore> list) {
        String[] result = new String[4];
        List<TbScore> pass = new ArrayList<>();
        List<TbScore> fail = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            TbScore score = list.get(i);
            if (score.getAvgScore() >= (float) 5) {
                pass.add(score);
            } else {
                fail.add(score);
            }
        }
        Integer numPass = pass.size();
        Integer numFail = fail.size();
        Float porPass = 100 * (float) numPass / (float) list.size();
        Float porFail = 100 * (float) numFail / (float) list.size();
        result[0] = numPass.toString();
        result[1] = numFail.toString();
        result[2] = porPass.toString();
        result[3] = porFail.toString();

        return result;
    }

    public Boolean addListScore(List<TbScore> list) {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            for (int i = 0; i < list.size(); i++) {
                TbScore std = list.get(i);
                session.save(std);
            }
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            return false;
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
            className = br.readLine().replaceAll("[^\\\\x00-\\\\x7F]", "");//.replaceAll("[^\\x00-\\x7F]", "");
            String header = br.readLine();
            records = CSVReader.readToBuffer(br);
        } catch (IOException e) {
            return false;
        }
        List<TbScore> listScore = new ArrayList<>();
        for (int i = 0; i < records.size(); i++) {
            List<String> metaData = records.get(i);
            String stdID = metaData.get(1);
            String fullName = metaData.get(2);
            Float middleExam = Float.valueOf(metaData.get(3));
            Float finalExam = Float.valueOf(metaData.get(4));
            Float plusExam = Float.valueOf(metaData.get(5));
            Float avgExam = Float.valueOf(metaData.get(6));
            TbScore std = new TbScore(stdID, fullName, middleExam, finalExam, plusExam, avgExam, className);
            listScore.add(std);
        }

        return addListScore(listScore);
    }
}
