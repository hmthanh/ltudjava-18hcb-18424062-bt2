/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JavaCode.HibernateUtils;
import Model.TbAccount;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sieus
 */
public class AccountDAO extends AbstractDAO<TbAccount> {
    public List<TbAccount> getAll(){
        return super.getAll("TbAccount");
    }
    @Override
    public Boolean importFromFile(String filename) {
        return false;
    }

    @Override
    public List<TbAccount> filter(String filter) {
        List<TbAccount> list = super.getAll("TbAccount");
        List<TbAccount> result = new ArrayList();
        Stream<TbAccount> stream = list.stream().filter((TbAccount item) -> {
            if (item == null){
                return false;
            }else{
                if (item.getPermit() != null){
                    return item.getPermit().toString().equals(filter);
                }
                else{
                    return false;
                }
            }
        });
        result = stream.collect(Collectors.toList());
        return result;
    }
	# Add role
    public Boolean hasRole(String username, String password, String permit) {
        List<TbAccount> list = filter(permit);
        for (int i = 0; i < list.size(); i++) {
            TbAccount acc = list.get(i);
            Boolean trueUsername = acc.getUsername().equals(username);
            Boolean truePassword = acc.getPassword().equals(password);
            if (trueUsername && truePassword) {
                return true;
            }
        }

        return false;
    }
    public Boolean update(TbAccount item){
        if (item == null) {
            return false;
        }
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(item);
            transaction.commit();
        } catch (HibernateException ex) {
//Log the exception
            transaction.rollback();
            System.err.println(ex);
            session.close();
            return false;
        }
        session.close();
        return true;
    }
    public Boolean updatePassword(String username, String password, String permit, String newPwd) {
        List<TbAccount> list = filter(permit);
        TbAccount findAcc = null;
        for (int i = 0; i < list.size(); i++) {
            TbAccount acc = list.get(i);
            Boolean trueUsername = acc.getUsername().equals(username);
            Boolean truePassword = acc.getPassword().equals(password);
            if (trueUsername && truePassword) {
                findAcc = acc;
                break;
            }
        }
        if (findAcc == null){
            return null;
        }else{
            findAcc.setPassword(newPwd);
            return update(findAcc);
        }
    }
}
