/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagement.dao.imp;

import static coursemanagement.connection.ConnectionDatabase.getConnection;
import coursemanagement.javafiles.User;
import coursemanagement.dao.UserDoa;
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
public class UserDoaImp implements UserDoa {
    

    @Override
    public User checkUserExist(String email, String password) throws SQLException, ClassNotFoundException{
        Connection connection = getConnection();
        try{
            PreparedStatement pstmt = connection.prepareStatement("select *from user where email = ? && password = ?");
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet resultSet = pstmt.executeQuery();
            User user = new User();
            if (resultSet.next()) {
                user.setFname(resultSet.getString("fName"));
                user.setMname(resultSet.getString("mName"));
                user.setLname(resultSet.getString("lName"));
                user.setId(resultSet.getInt("id"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setType(resultSet.getString("type"));
                user.setCurrentLevel(resultSet.getInt("current_level"));
            }else{
                return null;
            }
            return user;
            
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
             
    }
    
    
    @Override
    public int update(User user, int id) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            String updateSQL = "UPDATE `user` SET `fName`= ?,`mName`= ?,"
                    + "`Lname`= ?,`email`= ?,`phone`=?,`password`"
                    + "=?,`type`=? WHERE `id`=?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, user.getFname());
            preparedStatement.setString(2, user.getMname());
            preparedStatement.setString(3, user.getLname());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setString(7, user.getType());
            preparedStatement.setInt(8, user.getId());
            return preparedStatement.executeUpdate();
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return 0;
    }
    
    
    @Override
    public int updateLevel(int level, int id) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            String updateSQL = "UPDATE `user` SET `current_level`=? WHERE `id`=?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setInt(1, level);
            preparedStatement.setInt(2, id);

            return preparedStatement.executeUpdate();
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return 0;
    }
    
    
    @Override
    public int remove(int id, String type) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            if(type.equals("student")==true){
                String deleteSQL = "delete from students where student_id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }else if(type.equals("teacher")==true){
                String deleteSQL = "delete from teacher where teacher_id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
            String deleteSQL = "delete from user where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return 0;
    }
    
    @Override
    public int save(User user) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            String insertSQL = "INSERT INTO `user`(`fName`, `mName`, `Lname`, `email`, `phone`, "
                + "`password`, `type`, `current_level`) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, user.getFname());
            preparedStatement.setString(2, user.getMname());
            preparedStatement.setString(3, user.getLname());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setString(7, user.getType());
            if(user.getType().equals("student")){
                preparedStatement.setInt(8, 4);
            }else{
                preparedStatement.setInt(8, 0);
            }

            return preparedStatement.executeUpdate();
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return 0;
    }
    
    @Override
    public User findOne(int id) throws SQLException, ClassNotFoundException {
        //        Connection connection = getConnection();
//        try {
//            PreparedStatement pstmt = connection.prepareStatement(sql);
//        } catch (Exception e) {
//        }finally{
//            connection.close();
//        }
        Connection connection = getConnection();
        try {
            String sql = "select *from user where id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            
            User user = new User();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setFname(resultSet.getString("fname"));
                user.setMname(resultSet.getString("mname"));
                user.setLname(resultSet.getString("lname"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("type"));
            }
            return user;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
//    @Override
//    public User findOne(int id) throws SQLException, ClassNotFoundException {
//        Connection connection = null;
//        try {
//            connection = ConnectionDatabase.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement("select *from user where id = ?");
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            User user = new User();
//            while (resultSet.next()) {
//                user.setId(resultSet.getInt("id"));
//                user.setFname(resultSet.getString("fname"));
//                user.setMname(resultSet.getString("mname"));
//                user.setLname(resultSet.getString("lname"));
//                user.setEmail(resultSet.getString("email"));
//                user.setPhone(resultSet.getString("phone"));
//                user.setPassword(resultSet.getString("password"));
//                user.setType(resultSet.getString("type"));
//            }
//            return user;
//        } finally {
//            ConnectionDatabase.closeConnection(connection);
//        }
//    }

    
    @Override
    public List<User> findAll() throws SQLException, ClassNotFoundException {
        
      
        Connection connection = getConnection();
        try{
            List<User> users = new ArrayList<>();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select *from user");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFname(resultSet.getString("fname"));
                user.setMname(resultSet.getString("mname"));
                user.setLname(resultSet.getString("lname"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("type"));
                users.add(user);
            }
            return users;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
    @Override
    public List<User> findAll(String type) throws SQLException, ClassNotFoundException {
        
        Connection connection = getConnection();
        try{
            List<User> users = new ArrayList<>();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select *from user where type = ?");
            preparedStatement.setString(1, type);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFname(resultSet.getString("fname"));
                user.setMname(resultSet.getString("mname"));
                user.setLname(resultSet.getString("lname"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("type"));
                users.add(user);
            }
            return users;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
  
    
    @Override
    public List<User> search(String query) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            List<User> users = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select *from user where fname like concat ('%' ? '%')"
                    + "or mname like concat ('%' ? '%') "
                    + "or lname like concat ('%' ? '%') "
                    + "or phone like concat ('%' ? '%') "
                    + "or cast(id as char) like ('%' ? '%') "
                    + "or email like concat ('%' ? '%')");
            preparedStatement.setString(1, query);
            preparedStatement.setString(2, query);
            preparedStatement.setString(3, query);
            preparedStatement.setString(4, query);
            preparedStatement.setString(5, query);
            preparedStatement.setString(6, query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFname(resultSet.getString("fname"));
                user.setMname(resultSet.getString("mname"));
                user.setLname(resultSet.getString("lname"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("type"));
                users.add(user);
            }
            return users;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
      
    
    @Override
    public List<User> search(String query, String type) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            List<User> users = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM user WHERE "
                + "(fname LIKE CONCAT('%', ?, '%') "
                + "OR mname LIKE CONCAT('%', ?, '%') "
                + "OR lname LIKE CONCAT('%', ?, '%') "
                + "OR phone LIKE CONCAT('%', ?, '%') "
                + "OR CAST(id AS CHAR) LIKE CONCAT('%', ?, '%') "
                + "OR email LIKE CONCAT('%', ?, '%')) "
                + "AND type = ?");
            preparedStatement.setString(1, query);
            preparedStatement.setString(2, query);
            preparedStatement.setString(3, query);
            preparedStatement.setString(4, query);
            preparedStatement.setString(5, query);
            preparedStatement.setString(6, query);
            preparedStatement.setString(7, type);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFname(resultSet.getString("fname"));
                user.setMname(resultSet.getString("mname"));
                user.setLname(resultSet.getString("lname"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("type"));
                users.add(user);
            }
            return users;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
    @Override
    public User findOne(String email, String phone) throws SQLException, ClassNotFoundException {
       
        Connection connection = getConnection();
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select *from user where email = ? || phone = ?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, phone);

            ResultSet resultSet = preparedStatement.executeQuery();
            User user = new User();
            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setFname(resultSet.getString("fname"));
                user.setMname(resultSet.getString("mname"));
                user.setLname(resultSet.getString("lname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("type"));
            }else{
                return null;
            }
            return user;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
}
