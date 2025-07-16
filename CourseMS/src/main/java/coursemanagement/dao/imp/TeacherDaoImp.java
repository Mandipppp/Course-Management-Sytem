/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagement.dao.imp;

import static coursemanagement.connection.ConnectionDatabase.getConnection;
import coursemanagement.javafiles.Teacher;
import coursemanagement.dao.TeacherDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mandipraut
 */
public class TeacherDaoImp implements TeacherDao {
    
     

    @Override
    public List<Teacher> findAllModules(int teacherId) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            List <Teacher> teachers = new ArrayList<>();
             PreparedStatement preparedStatement = connection
                    .prepareStatement("select *from teacher where teacher_id = ?");
            preparedStatement.setInt(1, teacherId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacherId(resultSet.getInt("teacher_id"));
                teacher.setModuleId(resultSet.getInt("module_id"));
                teachers.add(teacher);
            }
            return teachers;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
    @Override
    public Teacher findOne(int teacherId, int moduleId) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select *from teacher where teacher_id = ? && module_id = ?");
            preparedStatement.setInt(1, teacherId);
            preparedStatement.setInt(2, moduleId);

            ResultSet resultSet = preparedStatement.executeQuery();
            Teacher teacher = new Teacher();
            if (resultSet.next()) {
                teacher.setModuleId(resultSet.getInt("module_id"));
                teacher.setTeacherId(resultSet.getInt("teacher_id"));
            }else{
                return null;
            }
            return teacher;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
    @Override
    public int remove(int teacherId, int moduleId) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            String deleteSQL = "delete from teacher where teacher_id = ? and module_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, teacherId);
            preparedStatement.setInt(2, moduleId);
            return preparedStatement.executeUpdate();
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return 0;
    }
    
    
    @Override
    public int save(Teacher teacher) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            String insertSQL = "INSERT INTO `teacher`(`teacher_id`, `module_id`)"
                    + " VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, teacher.getTeacherId());
            preparedStatement.setInt(2, teacher.getModuleId());
            return preparedStatement.executeUpdate();
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return 0;
    }
    
}
