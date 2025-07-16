/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagement.dao.imp;

import static coursemanagement.connection.ConnectionDatabase.getConnection;
import coursemanagement.dao.CoursesDoa;
import coursemanagement.javafiles.Courses;
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
public class CoursesDoaImp implements CoursesDoa{
    @Override
    public int save(Courses course) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            String insertSQL = "INSERT INTO `courses`(`courseName`, `isDeleted`) VALUES (?,0)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, course.getCourseName());
            return preparedStatement.executeUpdate();
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return 0;
    }
    
    @Override
    public List<Courses> findAll() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            List<Courses> courses = new ArrayList<>();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select *from courses where isDeleted = 0");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Courses course = new Courses();
                course.setCourseName(resultSet.getString("courseName"));
                course.setCourseId(resultSet.getInt("courseId"));
                course.setIsDeleted(resultSet.getInt("isDeleted"));
                courses.add(course);
            }
            return courses;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
    @Override
    public Courses findOne(String courseName) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select *from courses where courseName = ? and isDeleted = 0");
            preparedStatement.setString(1, courseName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Courses course = new Courses();
            if (resultSet.next()) {
                course.setCourseName(resultSet.getString("courseName"));
                course.setCourseId(resultSet.getInt("courseId"));
                course.setIsDeleted(resultSet.getInt("isDeleted"));
            }else{
                return null;
            }
            return course;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
    @Override
    public Courses findOne(int courseId) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select *from courses where courseId = ? and isDeleted = 0");
            preparedStatement.setInt(1, courseId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Courses course = new Courses();
            if (resultSet.next()) {
                course.setCourseName(resultSet.getString("courseName"));
                course.setCourseId(resultSet.getInt("courseId"));
                course.setIsDeleted(resultSet.getInt("isDeleted"));
            }else{
                return null;
            }
            return course;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
    @Override
    public int remove(int id) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            String deleteSQLCourses = "UPDATE `courses` SET `isDeleted`= 1 WHERE courseId = ?";
            String deleteSQLModules = "UPDATE `modules` SET `isDeleted`= 1 WHERE courseId = ?";

            PreparedStatement preparedStatementCourses = connection.prepareStatement(deleteSQLCourses);
            preparedStatementCourses.setInt(1, id);
            int rowsAffectedCourses = preparedStatementCourses.executeUpdate();

            PreparedStatement preparedStatementModules = connection.prepareStatement(deleteSQLModules);
            preparedStatementModules.setInt(1, id);
            int rowsAffectedModules = preparedStatementModules.executeUpdate();

            return rowsAffectedCourses + rowsAffectedModules;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return 0;
    }
}
