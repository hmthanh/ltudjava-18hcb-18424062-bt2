package Model;
// Generated Aug 7, 2019 9:04:54 AM by Hibernate Tools 4.3.1



/**
 * TbStudent generated by hbm2java
 */
public class TbStudent  implements java.io.Serializable {


     private Integer no;
     private Integer studentId;
     private String fullname;
     private String gender;
     private String idcard;

    public TbStudent() {
    }

    public TbStudent(Integer studentId, String fullname, String gender, String idcard) {
       this.studentId = studentId;
       this.fullname = fullname;
       this.gender = gender;
       this.idcard = idcard;
    }
   
    public Integer getNo() {
        return this.no;
    }
    
    public void setNo(Integer no) {
        this.no = no;
    }
    public Integer getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    public String getFullname() {
        return this.fullname;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getIdcard() {
        return this.idcard;
    }
    
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }




}


