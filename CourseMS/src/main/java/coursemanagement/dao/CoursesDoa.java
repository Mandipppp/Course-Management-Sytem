/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagement.dao;


import coursemanagement.javafiles.Courses;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mandipraut
 */
public interface CoursesDoa {
    int save(Courses course) throws SQLException, ClassNotFoundException;
    List<Courses> findAll() throws SQLException, ClassNotFoundException;
    Courses findOne(String courseName) throws SQLException, ClassNotFoundException;
    Courses findOne(int courseId) throws SQLException, ClassNotFoundException;
    int remove(int id) throws SQLException, ClassNotFoundException;

}
