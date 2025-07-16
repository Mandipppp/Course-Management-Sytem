/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagement.javafiles;

/**
 *
 * @author mandipraut
 */
public class Teacher {
    private int teacherId;
    private int moduleId;
    
    
    public Teacher(){
        
    }
    
    public Teacher(int teacherId, int moduleId){
        this.teacherId = teacherId;
        this.moduleId = moduleId;
        
    }
    
    public int getTeacherId(){
        return this.teacherId;
    }
    
    public void setTeacherId(int teacherId){
        this.teacherId = teacherId;
    }
    
    public int getModuleId(){
        return this.moduleId;
    }
    
    public void setModuleId(int moduleId){
        this.moduleId = moduleId;
    }
    
}
