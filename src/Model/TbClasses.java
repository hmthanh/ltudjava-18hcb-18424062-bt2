package Model;
// Generated Aug 24, 2019 3:06:05 PM by Hibernate Tools 4.3.1



/**
 * TbClasses generated by hbm2java
 */
public class TbClasses  implements java.io.Serializable {


     private Integer no;
     private String studentId;
     private String fullname;
     private String gender;
     private String cardId;
     private String subjectId;

    public TbClasses() {
    }

    public TbClasses(String studentId, String fullname, String gender, String cardId, String subjectId) {
       this.studentId = studentId;
       this.fullname = fullname;
       this.gender = gender;
       this.cardId = cardId;
       this.subjectId = subjectId;
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
    public String getCardId() {
        return this.cardId;
    }
    
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
    public String getSubjectId() {
        return this.subjectId;
    }
    
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }




}


