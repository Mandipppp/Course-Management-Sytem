/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagement.dao;



import coursemanagement.javafiles.Student;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mandipraut
 */
public interface StudentDoa {
    List<Student> findAll(int moduleId) throws SQLException, ClassNotFoundException;
    List<Student> findAll() throws SQLException, ClassNotFoundException;

    Student findOne(int studentId) throws SQLException, ClassNotFoundException;
    Student findOne(int studentId, int moduleId) throws SQLException, ClassNotFoundException;
    List<Student> search(String query, int moduleId) throws SQLException, ClassNotFoundException;
    int update(Student student, int studentId, int moduleId) throws SQLException, ClassNotFoundException;
    int save(Student student) throws SQLException, ClassNotFoundException;
}
