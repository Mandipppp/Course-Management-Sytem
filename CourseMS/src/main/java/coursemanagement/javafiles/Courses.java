/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagement.javafiles;

/**
 *
 * @author mandipraut
 */
public class Courses {
    private int courseId;
    private String courseName;
    private int isDeleted;
    
    public Courses(){
        
    }
    
    public Courses(int courseId, String courseName, int isDeleted){
        this.courseId = courseId;
        this.courseName = courseName;
        this.isDeleted = isDeleted;
    }
    
    public Courses(String courseName, int isDeleted){
        this.courseName = courseName;
        this.isDeleted = isDeleted;
    }
    
    public void setIsDeleted(int isDeleted){
        this.isDeleted = isDeleted;
    }
    
    public int getIsDeleted(){
        return this.isDeleted;
    }
    
    public void setCourseId(int courseId){
        this.courseId = courseId;
    }
    
    public int getCourseId(){
        return this.courseId;
    }
    
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    
    public String getCourseName(){
        return this.courseName;
    }
}
