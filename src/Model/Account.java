/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import JavaCode.Utils;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sieus
 */
@Entity
@Table(name = "tb_account")
public class Account implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "No")
    private Integer No;
    @Column(name = "Username")
    private String Username;
    @Column(name = "Password")
    private String Password;
    @Column(name = "Permit")
    private Integer Permit;

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" + "No=" + No + ", Username=" + Username + ", Password=" + Password + ", Permit=" + Permit + '}';
    }

    public Account(Integer No, String Username, String Password, Integer Permit) {
        this.No = No;
        this.Username = Username;
        this.Password = Password;
        this.Permit = Permit;
    }

    /**
     * @return the No
     */
    public Integer getNo() {
        return No;
    }

    /**
     * @param No the No to set
     */
    public void setNo(Integer No) {
        this.No = No;
    }

    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the Permit
     */
    public Integer getPermit() {
        return Permit;
    }

    /**
     * @param Permit the Permit to set
     */
    public void setPermit(Integer Permit) {
        this.Permit = Permit;
    }

}
