package Model;
// Generated Aug 24, 2019 3:06:05 PM by Hibernate Tools 4.3.1



/**
 * TbTimetable generated by hbm2java
 */
public class TbTimetable  implements java.io.Serializable {


     private Integer no;
     private Integer subjectId;
     private String subjectName;
     private Integer room;
     private Integer classId;
     private Integer studentId;

    public TbTimetable() {
    }

    public TbTimetable(Integer subjectId, String subjectName, Integer room, Integer classId, Integer studentId) {
       this.subjectId = subjectId;
       this.subjectName = subjectName;
       this.room = room;
       this.classId = classId;
       this.studentId = studentId;
    }
   
    public Integer getNo() {
        return this.no;
    }
    
    public void setNo(Integer no) {
        this.no = no;
    }
    public Integer getSubjectId() {
        return this.subjectId;
    }
    
    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }
    public String getSubjectName() {
        return this.subjectName;
    }
    
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public Integer getRoom() {
        return this.room;
    }
    
    public void setRoom(Integer room) {
        this.room = room;
    }
    public Integer getClassId() {
        return this.classId;
    }
    
    public void setClassId(Integer classId) {
        this.classId = classId;
    }
    public Integer getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }




}


