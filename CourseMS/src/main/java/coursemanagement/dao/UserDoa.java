/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagement.dao;

import coursemanagement.javafiles.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mandipraut
 */
public interface UserDoa {
//    int addUser(User user) throws SQLException, ClassNotFoundException;
//    int deleteUser(int id) throws SQLException, ClassNotFoundException;
    int update(User user, int id) throws SQLException, ClassNotFoundException;
    int updateLevel(int level, int id) throws SQLException, ClassNotFoundException;
    User checkUserExist(String email, String password) throws SQLException, ClassNotFoundException;
    User findOne(int id) throws SQLException, ClassNotFoundException;
    User findOne(String email, String Phone) throws SQLException, ClassNotFoundException;
    List<User> findAll() throws SQLException, ClassNotFoundException;
    List<User> findAll(String type) throws SQLException, ClassNotFoundException;
    List<User> search(String query) throws SQLException, ClassNotFoundException;
    List<User> search(String query, String type) throws SQLException, ClassNotFoundException;
    int remove(int id, String type) throws SQLException, ClassNotFoundException;
    int save(User user) throws SQLException, ClassNotFoundException;
    
    
}
