/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagement.dao;


import coursemanagement.javafiles.Modules;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mandipraut
 */
public interface ModulesDoa {
    Modules findOne(String moduleName) throws SQLException, ClassNotFoundException;
    Modules findOne(int moduleId) throws SQLException, ClassNotFoundException;
    int update(Modules module, int id) throws SQLException, ClassNotFoundException;
    int save(Modules module) throws SQLException, ClassNotFoundException;
    int remove(int id) throws SQLException, ClassNotFoundException;
    List<Modules> findAll() throws SQLException, ClassNotFoundException;
    List<Modules> search(String query) throws SQLException, ClassNotFoundException;
    List<Modules> findAll(int courseId) throws SQLException, ClassNotFoundException;
    List<Modules> findOptional(int courseId) throws SQLException, ClassNotFoundException;
    int saveOptional(Modules module) throws SQLException, ClassNotFoundException;
    List<Modules> findAll(int courseId, int level) throws SQLException, ClassNotFoundException;
}
