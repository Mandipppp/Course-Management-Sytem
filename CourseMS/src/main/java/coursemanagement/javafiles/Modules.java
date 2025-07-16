/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagement.javafiles;

import coursemanagement.dao.CoursesDoa;
import coursemanagement.javafiles.Courses;
import coursemanagement.dao.imp.CoursesDoaImp;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mandipraut
 */
public class Modules {
    private final CoursesDoa coursesDao = new CoursesDoaImp();

    private String module_name;
    private String courseName;
    
//    private Courses course;

    private int module_id;
    private List<Integer> level;
    private int isDeleted;
    private int courseId;
    
    public Modules(){
        
    }
    
    public Modules(int module_id, String module_name, List<Integer> level, int isDeleted, String courseName){
        this.courseName = courseName;
        this.isDeleted = isDeleted;
        this.module_id = module_id;
        this.module_name = module_name;
        this.level = level;
    }
    
    public Modules(String module_name, List<Integer> level, int isDeleted, String courseName){
        this.courseName = courseName;
        this.isDeleted = isDeleted;
        this.module_name = module_name;
        this.level = level;
    }
    
    public int getCourseId() throws SQLException, ClassNotFoundException{
        Courses course = coursesDao.findOne(this.courseName);
        courseId = course.getCourseId();
        return courseId;
    }
    
    public String getModuleName(){
        return this.module_name;
    }
    
    public void setModuleName(String module_name){
        this.module_name = module_name;
    }
    
    public int getCId(){
        return this.courseId;
    }
    
    public void setCId(int courseId){
        this.courseId = courseId;
    }
    
    public int getModuleId(){
        return this.module_id;
    }
    
    public void setModuleId(int module_id){
        this.module_id = module_id;
    }
    
    public List<Integer> getLevel() {
        return this.level;
    }

    public void setLevel(List<Integer> level) {
        this.level = level;
    }
    
    public int getIsDeleted(){
        return this.isDeleted;
    }
    
    public void setIsDeleted(int isDeleted){
        this.isDeleted = isDeleted;
    }
}
