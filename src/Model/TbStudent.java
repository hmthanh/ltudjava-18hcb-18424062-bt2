package Model;
// Generated Aug 15, 2019 4:13:09 PM by Hibernate Tools 4.3.1



/**
 * TbStudent generated by hbm2java
 */
public class TbStudent  implements java.io.Serializable {


     private Integer no;
     private String studentId;
     private String fullname;
     private String gender;
     private String idcard;
     private String classes;

    public TbStudent() {
    }

	
    public TbStudent(String gender) {
        this.gender = gender;
    }
    public TbStudent(String studentId, String fullname, String gender, String idcard, String classes) {
       this.studentId = studentId;
       this.fullname = fullname;
       this.gender = gender;
       this.idcard = idcard;
       this.classes = classes;
    }
   
    public Integer getNo() {
        return this.no;
    }
    
    public void setNo(Integer no) {
        this.no = no;
    }
    public String getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(String studentId) {
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
    public String getClasses() {
        return this.classes;
    }
    
    public void setClasses(String classes) {
        this.classes = classes;
    }




}


