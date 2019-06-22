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
import pe.edu.pucp.inf.mateproyecto.dao.DAOEmployee;
import pe.edu.pucp.inf.mateproyecto.model.bean.Area;
import pe.edu.pucp.inf.mateproyecto.model.bean.Employee;

/**
 *
 * @author Usuario
 */
public class MySQLEmployee implements DAOEmployee{

    @Override
    public int insert(Employee employee) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call InsertEmployee(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                     
            cs.setString(1, employee.getName());
            cs.setString(2, employee.getLastName()); 
            cs.setString(3, employee.getSecondLastName());
            cs.setString(4, employee.getDni());
            cs.setString(5, employee.getEmail());
            cs.setString(6, employee.getPhone());
            cs.setDate(7, (Date)employee.getBirthdate());
            cs.setInt(8, employee.getState());
            cs.setInt(9, employee.getArea().getId());
            cs.setString(10, employee.getRole());
            cs.setDate(11,(Date) employee.getContractStarDate());
            cs.setDate(12,(Date) employee.getContractEndDate());
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public int update(Employee employee) {
        int result = 0;
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call UpdateEmployee(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1,employee.getIdEmployee() );
            cs.setString(2, employee.getName());
            cs.setString(3, employee.getLastName()); 
            cs.setString(4, employee.getSecondLastName());
            cs.setString(5, employee.getDni());
            cs.setString(6, employee.getEmail());
            cs.setString(7, employee.getPhone());
            cs.setDate(8, (Date)employee.getBirthdate());
            cs.setInt(9, employee.getState());
            cs.setInt(10, employee.getPersonID());
            cs.setInt(11, employee.getArea().getId());
            cs.setString(12, employee.getRole());
            cs.setDate(13,(Date) employee.getContractStarDate());
            cs.setDate(14, (Date)employee.getContractEndDate());
            result = cs.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    
    }

    @Override
    public ArrayList<Employee> queryAll() {
        ArrayList<Employee> listEmployees = new ArrayList<Employee>();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            
            CallableStatement cs = con.prepareCall("{call GetAllEmployees()}");
            ResultSet rs = cs.executeQuery();
            CallableStatement cs2 = con.prepareCall("{call GetAreaById(?)}");
            
            
            while(rs.next()){
                Employee employee = new Employee();
                
                cs2.setInt(1, rs.getInt("AreaID"));
                ResultSet rs2 = cs2.executeQuery();
                rs2.next();
                Area area = new Area();
                area.setAbbreviation(rs2.getString("Abbreviation"));
                area.setDescription(rs2.getString("Description"));
                area.setId(rs2.getInt("AreaID"));
                area.setIdArea(rs2.getString("Id"));
                area.setState(rs2.getInt("State"));
                
                employee.setArea(area);
                employee.setBirthdate(rs.getDate("Birthdate"));
                employee.setContractEndDate(rs.getDate("Contractenddate"));
                employee.setContractStarDate(rs.getDate("Contractstartdate"));
                employee.setDni(rs.getString("Dni"));
                employee.setEmail(rs.getString("Email"));
                employee.setPersonID(rs.getInt("PersonID"));
                employee.setLastName(rs.getString("Lastname"));
                employee.setName(rs.getString("Name"));
                employee.setPhone(rs.getString("Phone"));
                employee.setRole(rs.getString("Role"));
                employee.setSecondLastName(rs.getString("Secondlastname"));
                employee.setState(rs.getInt("State"));
                employee.setIdEmployee(rs.getInt("EmployeeID"));
      
                            
                listEmployees.add(employee);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return listEmployees;
    
    }

    @Override
    public Employee queryById(int idEmployee) {
        //idEmployee = DNI employee
        Employee employee = new Employee();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetEmployeeById(?)}");
            cs.setInt(1,idEmployee);
            ResultSet rs= cs.executeQuery();
            rs.next();
            CallableStatement cs2 = con.prepareCall("{call GetAreaById(?)}");
            
            cs2.setInt(1, rs.getInt("AreaID"));
            ResultSet rs2 = cs2.executeQuery();
            rs2.next();
            Area area = new Area();
            area.setAbbreviation(rs2.getString("Abbreviation"));
            area.setDescription(rs2.getString("Description"));
            area.setId(rs2.getInt("AreaID"));
            area.setIdArea(rs2.getString("Id"));
            area.setState(rs2.getInt("State"));
                
            employee.setArea(area);
            employee.setBirthdate(rs.getDate("Birthdate"));
            employee.setContractEndDate(rs.getDate("Contractenddate"));
            employee.setContractStarDate(rs.getDate("Contractstartdate"));
            employee.setDni(rs.getString("Dni"));
            employee.setEmail(rs.getString("Email"));
            employee.setPersonID(rs.getInt("PersonID"));
            employee.setLastName(rs.getString("Lastname"));
            employee.setName(rs.getString("Name"));
            employee.setPhone(rs.getString("Phone"));
            employee.setRole(rs.getString("Role"));
            employee.setSecondLastName(rs.getString("Secondlastname"));
            employee.setState(rs.getInt("State"));
            employee.setIdEmployee(idEmployee);
      
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return employee;
    }

    @Override
    public Employee queryEmployee(String infEmployee) {
        Employee employee = new Employee();
        try{
            DBManager dbManager = DBManager.getDbManager();
            Connection con = DriverManager.getConnection(dbManager.getUrl(), dbManager.getUser(), dbManager.getPassword());
            CallableStatement cs = con.prepareCall("{call GetEmployeeByDNI(?)}");
            cs.setString(1,infEmployee);
            ResultSet rs= cs.executeQuery();
            rs.next();
            CallableStatement cs2 = con.prepareCall("{call GetAreaById(?)}");
            
            cs2.setInt(1, rs.getInt("AreaID"));
            ResultSet rs2 = cs2.executeQuery();
            rs2.next();
            Area area = new Area();
            area.setAbbreviation(rs2.getString("Abbreviation"));
            area.setDescription(rs2.getString("Description"));
            area.setId(rs2.getInt("AreaID"));
            area.setIdArea(rs2.getString("Id"));
            area.setState(rs2.getInt("State"));
                
            employee.setArea(area);
            employee.setBirthdate(rs.getDate("Birthdate"));
            employee.setContractEndDate(rs.getDate("Contractenddate"));
            employee.setContractStarDate(rs.getDate("Contractstartdate"));
            employee.setDni(infEmployee );
            employee.setEmail(rs.getString("Email"));
            employee.setPersonID(rs.getInt("PersonID"));
            employee.setLastName(rs.getString("Lastname"));
            employee.setName(rs.getString("Name"));
            employee.setPhone(rs.getString("Phone"));
            employee.setRole(rs.getString("Role"));
            employee.setSecondLastName(rs.getString("Secondlastname"));
            employee.setState(rs.getInt("State"));
            employee.setIdEmployee(rs.getInt("EmployeeID"));
      
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return employee;
    
    
    }
    
}
