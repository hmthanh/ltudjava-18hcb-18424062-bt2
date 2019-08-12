/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JavaCode.HibernateUtil;
import Model.TbAccount;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sieus
 */
public class AccountDAO {

    public List<TbAccount> getAll() {
        List<TbAccount> ds = null;
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "from TbAccount";
            ds = session.createQuery(hql).list();
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    public TbAccount getAccount(String username, String password, Integer permit) {
        TbAccount acc = null;
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "SELECT acc from TbAccount acc WHERE acc.username = :name AND acc.password = :pwd";
            Query query = session.createQuery(hql);
            query.setParameter("name", username);
            query.setParameter("pwd", password);
            acc = (TbAccount) query.list().get(0);
        } catch (HibernateException ex) {
            System.err.println(ex);
        } finally {
            session.close();
        }

        return acc;
    }

    public Boolean hasPermit(String username, String password, Integer permit) {
        List<TbAccount> accounts = getAll();
        boolean trueUsername;
        boolean truePassword;
        boolean truePermit;
        if (accounts != null) {
            for (int i = 0; i < accounts.size(); i++) {
                TbAccount account = accounts.get(i);
                trueUsername = account.getUsername().equals(username);
                truePassword = account.getPassword().equals(password);
                truePermit = account.getPermit().equals(permit);

                if (trueUsername && truePassword && truePermit) {
                    return true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối cơ sở dữ liệu", "Thất bại\"", JOptionPane.INFORMATION_MESSAGE);
        }

        return false;
    }

    public Boolean updateAccount(TbAccount newUpdate) {
        Session session = null;
        Transaction transaction = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            TbAccount acc = (TbAccount) session.get(TbAccount.class, newUpdate.getNo());
            acc.setPassword(newUpdate.getPassword());
            session.update(acc);
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
