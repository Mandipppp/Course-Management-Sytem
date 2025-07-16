/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagement.javafiles;

/**
 *
 * @author mandipraut
 */
public class Student {
    private int studentId;
    private int moduleId;
    private int courseId;
    private int marks;
    private String grade;
    
    
    public Student(){
        
    }
    
    public Student(int studentId, int moduleId, int marks, String grade, int courseId){
        this.studentId = studentId;
        this.moduleId = moduleId;
        this.marks = marks;
        this.grade = grade; 
        this.courseId = courseId;
    }
    
    public int getStudentId(){
        return this.studentId;
    }
    
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }
    
    public int getCourseId(){
        return this.courseId;
    }
    
    public void setCourseId(int courseId){
        this.courseId = courseId;
    }
    
    public int getModuleId(){
        return this.moduleId;
    }
    
    public void setModuleId(int moduleId){
        this.moduleId = moduleId;
    }
    
    public int getMarks(){
        return this.marks;
    }
    
    public void setMarks(int marks){
        this.marks = marks;
    }
    
    public String getGrade(){
        return this.grade;
    }
    
    public void setGrade(String grade){
        this.grade = grade;
    }
}
