/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JavaCode.HibernateUtil;
import Model.TbClasses;
import Model.TbStudent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sieus
 */
public class ClassDAO {

    public List<TbClasses> getAll() {
        List<TbClasses> ds = null;
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from TbClasses";
            ds = session.createQuery(hql).list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    public List<TbClasses> getAllBySubject(String subject) {
        List<TbClasses> list = getAll();
        List<TbClasses> result = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            TbClasses cls = list.get(i);
            if (cls.getSubjectId() == null ? subject == null : cls.getSubjectId().equals(subject)) {
                result.add(cls);
            }
        }
        return result;
    }

    public List<String> getAllSubject() {
        List<TbClasses> list = getAll();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            TbClasses cls = list.get(i);
            set.add(cls.getSubjectId());
        }
        String[] arr = set.toArray(new String[0]);
        return Arrays.asList(arr);
    }

    public Boolean addListScore(List<TbClasses> list) {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            for (int i = 0; i < list.size(); i++) {
                TbClasses std = list.get(i);
                session.save(std);
            }
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public Boolean removeSubject(List<TbClasses> list) {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            for (int i = 0; i < list.size(); i++) {
                TbClasses cls = list.get(i);
                String strQuery = "delete from TbClasses where no= :no";
                Query query = session.createQuery(strQuery);
                query.setInteger("no", cls.getNo());
                query.executeUpdate();
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
    
    public Boolean addClass(TbClasses cls) {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(cls);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
}
