/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagement.javafiles;

/**
 *
 * @author mandipraut
 */
public class User {
    private int id;
    private String fname;
    private String mname;
    private String lname;
    private String email;
    private String password;
    private String phone;
    private String type;
    private int currentLevel;

    private boolean hasSelected;

    
    public User(){
    }
    
    public User(int id, String fname, String mname, String lname, String email, String password, String phone, String type, int currentLevel){
        this.id = id;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.type = type;
        this.currentLevel = currentLevel;
    }
    
    public User(String fname, String mname, String lname, String email, String password, String phone, String type, int currentLevel){
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.type = type;
        this.currentLevel = currentLevel;
    }
    
    public String getFullName(){
        if(this.mname.equals("")){
            return this.fname+" "+this.lname;
        }else{
            return this.fname+" "+this.mname+" "+this.lname;
        }
    }
    
    public void setCurrentLevel(int currentLevel){
        this.currentLevel = currentLevel;
    }
    
    public int getCurrentLevel(){
        return this.currentLevel;
    }
    
    public boolean gethasSelected(){
        return this.hasSelected;
    }
    
    public void sethasSelected(boolean hasSelected){
        this.hasSelected = hasSelected;
    }
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getType(){
        return this.type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public String getPhone(){
        return this.phone;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public String getFname(){
        return this.fname;
    }
    
    public void setFname(String fname){
        this.fname = fname;
    }
    
    public String getMname(){
        return this.mname;
    }
    
    public void setMname(String mname){
        this.mname = mname;
    }
    
    public String getLname(){
        return this.lname;
    }
    
    public void setLname(String lname){
        this.lname = lname;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
}
