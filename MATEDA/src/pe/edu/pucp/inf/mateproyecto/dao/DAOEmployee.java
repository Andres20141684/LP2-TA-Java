/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.inf.mateproyecto.dao;

import java.util.ArrayList;
import pe.edu.pucp.inf.mateproyecto.model.bean.Employee;

/**
 *
 * @author Usuario
 */
public interface DAOEmployee {
    int insert(Employee employee);
    int update(Employee employee);
    ArrayList<Employee> queryAll();
    Employee queryById(int idEmployee);
    Employee queryEmployee(String infEmployee);
    
}
