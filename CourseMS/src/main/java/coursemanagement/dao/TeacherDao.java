/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagement.dao;

import coursemanagement.javafiles.Teacher;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mandipraut
 */
public interface TeacherDao {
    List<Teacher> findAllModules(int teacherId ) throws SQLException, ClassNotFoundException;
    Teacher findOne(int teacherId, int moduleId) throws SQLException, ClassNotFoundException;
    int save(Teacher teacher) throws SQLException, ClassNotFoundException;
    int remove(int teacherId, int moduleId) throws SQLException, ClassNotFoundException;
}
