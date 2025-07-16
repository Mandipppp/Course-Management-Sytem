/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagement.dao.imp;

import static coursemanagement.connection.ConnectionDatabase.getConnection;
import coursemanagement.javafiles.Modules;
import coursemanagement.dao.ModulesDoa;
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
public class ModulesDoaImp implements ModulesDoa {
    
    @Override
    public Modules findOne(String moduleName) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select *from modules where module_name = ? and isDeleted=0");
            preparedStatement.setString(1, moduleName);

            ResultSet resultSet = preparedStatement.executeQuery();
            Modules module = new Modules();
            List<Integer> level = new ArrayList<>();
            if (resultSet.next()) {
                level.add(resultSet.getInt("level"));
                module.setLevel(level);
                module.setModuleId(resultSet.getInt("module_id"));
                module.setModuleName(resultSet.getString("module_name"));

            }else{
                return null;
            }
            return module;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
    @Override
    public Modules findOne(int moduleId) throws SQLException, ClassNotFoundException{
        Connection connection = getConnection();
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select *from modules where module_id = ? and isDeleted = 0");
            preparedStatement.setInt(1, moduleId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Modules module = new Modules();
            List<Integer> level = new ArrayList<>();
            if (resultSet.next()) {
                level.add(resultSet.getInt("level"));
                module.setLevel(level);
                module.setModuleId(resultSet.getInt("module_id"));
                module.setModuleName(resultSet.getString("module_name"));
                module.setCId(resultSet.getInt("courseId"));
            }else{
                return null;
            }
            return module;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
    @Override
    public int update(Modules module, int id) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            String updateSQL = "UPDATE `modules` SET `module_name`= ?,`level`= ?,"
                    + "`courseId`= ? WHERE `module_id`=?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, module.getModuleName());
            List<Integer> level = module.getLevel();
            preparedStatement.setInt(2, level.get(0));
            preparedStatement.setInt(3, module.getCId());
            preparedStatement.setInt(4, id);
            return preparedStatement.executeUpdate();
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return 0;
    }
    
    @Override
    public int remove(int id) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            String deleteSQL = "UPDATE `modules` SET `isDeleted`= 1 WHERE module_id = ?";
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
    public int save(Modules module) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            List<Integer> levels = module.getLevel();
            int rowsAffected = 0;
            for(int level: levels){
                String insertSQL = "INSERT INTO `modules`(`module_name`, `level`, `courseId`, `isDeleted`,`isOptional`) "
                        + "VALUES (?, ?, ?, ?,0)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
                preparedStatement.setString(1, module.getModuleName());
                preparedStatement.setInt(2, level);
                preparedStatement.setInt(3, module.getCourseId());
                preparedStatement.setInt(4, module.getIsDeleted());
                rowsAffected += preparedStatement.executeUpdate();
            }    
            return rowsAffected;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return 0;
    }
    
    @Override
    public int saveOptional(Modules module) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            List<Integer> levels = module.getLevel();
            int rowsAffected = 0;
            
            String insertSQL = "INSERT INTO `modules`(`module_name`, `level`, `courseId`, `isDeleted`,`isOptional`) "
                    + "VALUES (?, 6, ?, ?,1)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, module.getModuleName());

            preparedStatement.setInt(2, module.getCourseId());
            preparedStatement.setInt(3, module.getIsDeleted());
            rowsAffected += preparedStatement.executeUpdate();  
            return rowsAffected;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return 0;
    }
//    @Override
//    public List<Modules> search(String query) throws SQLException, ClassNotFoundException {
//        List<Modules> modules = new ArrayList<>();
//        PreparedStatement preparedStatement = getConnection().prepareStatement(
//                "select *from modules where (module_name like concat ('%' ? '%')"
//                + "or cast(level as char) like ('%' ? '%') "
//                + "or cast(module_id as char) like ('%' ? '%')) and isDeleted = 0");
//        preparedStatement.setString(1, query);
//        preparedStatement.setString(2, query);
//        preparedStatement.setString(3, query);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            Modules module = new Modules();
//             List<Integer> level = new ArrayList<>();
//             level.add(resultSet.getInt("level"));
//
//            module.setCId(resultSet.getInt("courseId"));
//            module.setModuleName(resultSet.getString("module_name"));
//            module.setLevel(level);
//            module.setModuleId(resultSet.getInt("module_id"));
//            
//            modules.add(module);
//        }
//        return modules;
//    }
    
    //added
    @Override
    public List<Modules> search(String query) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try {
            List<Modules> modules = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select *from modules where (module_name like concat ('%' ? '%')"
                    + "or cast(level as char) like ('%' ? '%') "
                    + "or cast(module_id as char) like ('%' ? '%')) and isDeleted = 0");
            preparedStatement.setString(1, query);
            preparedStatement.setString(2, query);
            preparedStatement.setString(3, query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Modules module = new Modules();
                 List<Integer> level = new ArrayList<>();
                 level.add(resultSet.getInt("level"));

                module.setCId(resultSet.getInt("courseId"));
                module.setModuleName(resultSet.getString("module_name"));
                module.setLevel(level);
                module.setModuleId(resultSet.getInt("module_id"));

                modules.add(module);
            }
            return modules;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
    @Override
    public List<Modules> findAll() throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            List<Modules> modules = new ArrayList<>();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select *from modules where isDeleted = 0");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                List<Integer> level = new ArrayList<>();
                level.add(resultSet.getInt("level"));
                Modules module = new Modules();
                module.setCId(resultSet.getInt("courseId"));
                module.setIsDeleted(resultSet.getInt("isDeleted"));
                module.setModuleId(resultSet.getInt("module_id"));
                module.setModuleName(resultSet.getString("module_name"));
                module.setLevel(level);
                modules.add(module);
            }
            return modules;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
    @Override
    public List<Modules> findAll(int courseId, int currentlevel) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            List<Modules> modules = new ArrayList<>();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select *from modules where courseId = ? and level = ? and isDeleted = 0");
            preparedStatement.setInt(1, courseId);
            preparedStatement.setInt(2, currentlevel);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                List<Integer> level = new ArrayList<>();
                level.add(resultSet.getInt("level"));
                Modules module = new Modules();
                module.setCId(resultSet.getInt("courseId"));
                module.setIsDeleted(resultSet.getInt("isDeleted"));
                module.setModuleId(resultSet.getInt("module_id"));
                module.setModuleName(resultSet.getString("module_name"));
                module.setLevel(level);
                modules.add(module);
            }
            return modules;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
    @Override
    public List<Modules> findAll(int courseId) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            List<Modules> modules = new ArrayList<>();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select *from modules where courseId = ? ");
            preparedStatement.setInt(1, courseId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                List<Integer> level = new ArrayList<>();
                level.add(resultSet.getInt("level"));
                Modules module = new Modules();
                module.setCId(resultSet.getInt("courseId"));
                module.setIsDeleted(resultSet.getInt("isDeleted"));
                module.setModuleId(resultSet.getInt("module_id"));
                module.setModuleName(resultSet.getString("module_name"));
                module.setLevel(level);
                modules.add(module);
            }
            return modules;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
    
    @Override
    public List<Modules> findOptional(int courseId) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        try{
            List<Modules> modules = new ArrayList<>();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select *from modules where courseId = ? and isOptional = 1 and isDeleted = 0");
            preparedStatement.setInt(1, courseId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                List<Integer> level = new ArrayList<>();
                level.add(resultSet.getInt("level"));
                Modules module = new Modules();
                module.setCId(resultSet.getInt("courseId"));
                module.setIsDeleted(resultSet.getInt("isDeleted"));
                module.setModuleId(resultSet.getInt("module_id"));
                module.setModuleName(resultSet.getString("module_name"));
                module.setLevel(level);
                modules.add(module);
            }
            return modules;
        }catch(SQLException e){
            
        }finally{
            connection.close();
        }
        return null;
    }
}
