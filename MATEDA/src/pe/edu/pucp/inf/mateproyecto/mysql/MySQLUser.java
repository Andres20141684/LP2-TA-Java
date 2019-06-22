/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.inf.mateproyecto.config.DBManager;
import pe.edu.pucp.inf.mateproyecto.dao.DAOUser;
import pe.edu.pucp.inf.mateproyecto.model.bean.Employee;
import pe.edu.pucp.inf.mateproyecto.model.bean.User;

/**
 *
 * @author Usuario
 */
public class MySQLUser implements DAOUser {

    @Override
    public int insert(User user) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call InsertUser(?,?,?,?,?,?,?)}");
            cs.setInt(1,user.getState());
            cs.setInt(2,user.getEmployee().getIdEmployee());
            cs.setString(3,user.getPassword());
            cs.setString(4,user.getUser());
            cs.setDate(5, (Date) user.getExpirationDate());
            cs.setInt(6, user.getUserType());

            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
        
        
    }


    @Override
    public int update(User user) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdateUser(?,?,?,?,?,?,?)}");
            cs.setInt(1, user.getState());
            cs.setInt(2, user.getEmployee().getIdEmployee());
            cs.setString(3, user.getPassword());
            cs.setString(4, user.getUser());
            cs.setDate(5, (Date) user.getExpirationDate());
            cs.setInt(6, user.getUserType());
            cs.setInt(7, user.getId());
            result = cs.executeUpdate();
            con.close();
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public ArrayList<User> queryAll() {
        ArrayList<User> listUsers = new ArrayList<User>();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetAllUsers()}");
            ResultSet rs = cs.executeQuery();
            
                      
            while(rs.next()){
                User user = new User();
                user.setExpirationDate(rs.getDate("Expirationdate"));
                user.setId(rs.getInt("UserID"));
                user.setPassword(rs.getString("Password"));
                user.setUser(rs.getString("User"));
                user.setState(rs.getInt("State"));
                user.setUserType(rs.getInt("UserType"));
                
                //employee
                MySQLEmployee employeeControl = new MySQLEmployee();
                Employee employee = employeeControl.queryById(rs.getInt("EmployeeID"));
                user.setEmployee(employee);
                
                listUsers.add(user);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return listUsers;
    }

    @Override
    public User queryUser(String infuser) {
        User user = new User();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetUserByUsername(?)}");
            cs.setString(1, infuser);
            ResultSet rs = cs.executeQuery();
            
                      
            rs.next();
            user.setExpirationDate(rs.getDate("Expirationdate"));
            user.setId(rs.getInt("UserID"));
            user.setPassword(rs.getString("Password"));
            user.setUser(rs.getString("User"));
            user.setState(rs.getInt("State"));
            user.setUserType(rs.getInt("UserType"));
                
                //employee
            MySQLEmployee employeeControl = new MySQLEmployee();
            Employee employee = employeeControl.queryById(rs.getInt("EmployeeID"));
            user.setEmployee(employee);
                
                
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return user;
        
        
       
    }

    
}
