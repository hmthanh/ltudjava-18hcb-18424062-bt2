package Model;
// Generated Aug 24, 2019 3:06:05 PM by Hibernate Tools 4.3.1



/**
 * TbAccount generated by hbm2java
 */
public class TbAccount  implements java.io.Serializable {


     private Integer no;
     private String username;
     private String password;
     private Integer permit;

    public TbAccount() {
    }

    public TbAccount(String username, String password, Integer permit) {
       this.username = username;
       this.password = password;
       this.permit = permit;
    }
   
    public Integer getNo() {
        return this.no;
    }
    
    public void setNo(Integer no) {
        this.no = no;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getPermit() {
        return this.permit;
    }
    
    public void setPermit(Integer permit) {
        this.permit = permit;
    }




}


