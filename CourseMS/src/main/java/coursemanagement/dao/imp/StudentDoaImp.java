/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagement.dao.imp;

import static coursemanagement.connection.ConnectionDatabase.getConnection;
import coursemanagement.javafiles.Student;
import coursemanagement.dao.StudentDoa;
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
public class StudentDoaImp implements StudentDoa{
    

    @Override
    public List<Student> findAll(int moduleId) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            List<Student> students = new ArrayList<>();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select *from students where module_id = ?");
            preparedStatement.setInt(1, moduleId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setGrade(resultSet.getString("grade"));
                student.setMarks(resultSet.getInt("marks"));
                student.setModuleId(resultSet.getInt("module_id"));
                student.setStudentId(resultSet.getInt("student_id"));
                student.setCourseId(resultSet.getInt("course_id"));

                students.add(student);
            }
            return students;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
    @Override
    public List<Student> findAll() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            List<Student> students = new ArrayList<>();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select *from students");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setGrade(resultSet.getString("grade"));
                student.setMarks(resultSet.getInt("marks"));
                student.setModuleId(resultSet.getInt("module_id"));
                student.setStudentId(resultSet.getInt("student_id"));
                student.setCourseId(resultSet.getInt("course_id"));

                students.add(student);
            }
            return students;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
     @Override
    public List<Student> search(String query, int moduleId) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            List<Student> students = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select *from students where (cast(student_id as char) like ('%' ? '%') "
                    + "or cast(module_id as char) like ('%' ? '%')) and module_id = ?");
            preparedStatement.setString(1, query);
            preparedStatement.setString(2, query);
            preparedStatement.setInt(3, moduleId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setGrade(resultSet.getString("grade"));
                student.setMarks(resultSet.getInt("marks"));
                student.setModuleId(resultSet.getInt("module_id"));
                student.setStudentId(resultSet.getInt("student_id"));
                student.setCourseId(resultSet.getInt("course_id"));
                students.add(student);
            }
            return students;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
    @Override
    public int save(Student student) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            String insertSQL = "INSERT INTO `students`(`student_id`, `module_id`, `marks`, `grade`, `course_id`)"
                    + " VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, student.getStudentId());
            preparedStatement.setInt(2, student.getModuleId());
            preparedStatement.setInt(3, student.getMarks());
            preparedStatement.setString(4, student.getGrade());
            preparedStatement.setInt(5, student.getCourseId());
            return preparedStatement.executeUpdate();
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return 0;
    }
    
    @Override
    public Student findOne(int studentId) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select *from students where student_id = ?");
            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = new Student();
            if (resultSet.next()) {
                student.setStudentId(resultSet.getInt("student_id"));
                student.setMarks(resultSet.getInt("marks"));
                student.setGrade(resultSet.getString("grade"));
                student.setModuleId(resultSet.getInt("module_id"));
                student.setCourseId(resultSet.getInt("course_id"));

            }else{
                return null;
            }
            return student;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
    @Override
    public Student findOne(int studentId, int moduleId) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select *from students where student_id = ? and module_id = ?");
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, moduleId);

            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = new Student();
            if (resultSet.next()) {
                student.setStudentId(resultSet.getInt("student_id"));
                student.setMarks(resultSet.getInt("marks"));
                student.setGrade(resultSet.getString("grade"));
                student.setModuleId(resultSet.getInt("module_id"));
                student.setCourseId(resultSet.getInt("course_id"));

            }else{
                return null;
            }
            return student;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
    @Override
    public int update(Student student, int studentId, int moduleId) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            String updateSQL = "UPDATE `students` SET `marks`= ? , `grade` = ?"
                    + "WHERE `student_id`=? and `module_id` = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setInt(1, student.getMarks());
            preparedStatement.setString(2, student.getGrade());

            preparedStatement.setInt(3, studentId);
            preparedStatement.setInt(4, moduleId);

            return preparedStatement.executeUpdate();
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return 0;
    }
   
}
